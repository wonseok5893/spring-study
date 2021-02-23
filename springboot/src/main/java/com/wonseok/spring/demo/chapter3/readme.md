#Chapter 3
### 템플릿

#### 템플릿 메소드 패턴
1. 확장이 가능하지만 상속을 통한 확장으로 유연성이 떨어진다.
-> 컴파일 시에 그 관계가 설정된다.

#### 전략 패턴
개방폐쇄원칙 OCP를 잘 지키는 구조.
<pre>
<code>
    컨텍스트 -----> 전략 (interface)
               ㅣ ㅣ
               A   B  (class) 
</code>
</pre>

#### UserDao 와 JdbcContext
- 둘은 인터페이스를 사이에 두지 않고 의존관계를 맺는다.  
-> 긴밀한 관계를 가지고 강한 응집도를 가지면 직접 DI를 해도 된다.  

#### UserDao -> JdbcContext -> StatementStrategy
- 전략 패턴이 적용되었다.
- 익명클래스를 활용하여 일부만 자주 바꿔 사용하는 패턴
> 스프링은 이 패턴을 템플릿/콜백 패턴이라고 부른다.
- 전략패턴의 컨택스트를 템플릿, 익명 내부 클래스로 만들어지는 오브젝트를 콜백이라고 부른다.

전략 패턴 - 여러개의 메소드를 가진 인터페이스
템플릿/콜백 패턴 - 1. 보통 한 개의 메소드를 가진 단일 메소드 인터페이스를 사용 (람다 사용 가능)
                2. 메소드 단위로 사용할 오브젝트를 전달 받는다.
                
#### 템플릿 콜백 패턴 적용
<pre>
<code>
    계산기를 예로 사용
    
    한번 두번 반복되는 코드가 아닌 여러번 재사용 도는 코드는 코드내에서 변하는 것 과 변하지 않는 것을 분리
    
    ! 변하지 않는 것은 template()으로 정의 해두고 ※제너릭을 사용하여 타입 추상화
    public <T> T template(String filePath, LineCallback<T> callback, T initValue)throws IOException{
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(filePath));
                T res = initValue;
                String line = null;
                while((line = br.readLine())!=null){
                    res = callback.doSomething(line, res);
                }
                return res;
            } catch (IOException e) {...}
              finally {...}
        }
    
    ! 변하는 것은 콜백 인터페이스로 사용한다.
    
    public interface LineCallback<T> {
    
        T doSomething(String line, T value );
    }
    
    !람다식을 사용하여 한줄로 사용할 수 있다.
    
    @Test
        void 덧셈() throws IOException {
            int res = calculator.template(getClass().getResource("/numbers.txt").getPath(), (String line, Integer e) -> e + Integer.parseInt(line), 1);
            assertEquals(res,11);
        }
    
        @Test
        void 문자이어붙이기() throws IOException {
            String res = calculator.template(getClass().getResource("/numbers.txt").getPath(),(line,e)->e+line,"");
            assertEquals(res,"1234");
        }    
</code>
</pre> 


### JdbcTemplate
> 스프링이 제공하는 템플릿/콜백 기술 -> JdbcTemplate
* execute -> void;
* query -> return;
<pre>
<code>
    * 유저 수 조회
    public int getCount(){
        return this.jdbcTemplate.query(
            new PreparedStatementCreator(){
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
                    return con.prepareStatement("select count(*) from users");
                }
            }, 
            new ResultSetExtractor<T>(){
                public T extractData(ResultSet rs) throws SQLException, DataAccessException {
                    rs.next();
                    return rs.getInt(1);
                }    
            });
    }
    
    jdbcTemplate가 다음과 같이 정수 하나를 반환하는 메소드를 제공
    => jdbcTemplate.queryForInt("select count(*) from users");
    
    * User id로 조회
    jdbcTemplate.queryForObject("select * from Users where id = ?",
                                 new Object[]{id}, -> sql에 바인딩할 파라미터 값, 가변인자 대신 배열을 사용한다.
                                 new RowMapper<User>(){
                                    public User mapRow(ResultSet rs, int rowNum){
                                        User user = new User();
                                        user.setId(rs.getString("id"));                                                                                                           
                                        user.setName(rs.getString("name"));                                                                                                           
                                        user.setPassword(rs.getString("password"));                                                                                                           
                                        return user;
                                    }
                                 });   
</code>
</pre>                

