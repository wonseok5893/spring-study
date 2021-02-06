#### 제어의 역전과 의존관계 주입

 1. 인터페이스를 이용한 느슨한 결합, 외부로부터 객체를 주입받아 사용  
   ->  구체적인 클래스를 알 필요가 없음, 유지보수의 간결화
 
#### 분리와 확장을 고려한 설계
 > 프로그래밍의 기초 개념 - SoC 
 > SoC = 관심사의 분리     

#### 디자인 패턴
> 소프트웨어 설계 시 특정상황에서 자주 만나는 문제를 해결하기 위해 사용할 수 있는 재사용 가능한 솔루션  

대부분 패턴의 설계 구조는 비슷하다. 
- 두 가지 구조로 정리
    1. 상속
    2. 오브젝트 합성

> 템플릿 메소드 패턴
<pre>
<code>
    public abstract class Super{
        public void templateMethod(){
        // 기본 알고리즘 코드
        hookMethod(); // 이미 정의해두거나 오버라이드할 수 있도록 만든 메소드 
        abstractMethod();
        ...
        }
        protected void hookMethod(){ }
        public abstract void abstractMethod();
    }
    
    public class Sub1 extends Super{
        @Override 
        protected void hookMethod(){
            ...
        }
       
        public void abstractMethod(){
            ...
        }
    }        
</code>
</pre>

 > 팩토리 메소드 패턴
 1. 템플릿 메소드와 마찬가지로 상속을 통해 기능을 확장하게 하는 패턴
 2. 인터페이스를 리턴한다.
 <pre>
 <code>
     public abstract class Super{
         public void templateMethod(){
         // 기본 알고리즘 코드
         hookMethod(); // 이미 정의해두거나 오버라이드할 수 있도록 만든 메소드 
         getConnection();
         ...
         }
         protected void hookMethod(){ }
         public abstract Connection getConnection();
     }
     
     public class Sub1 extends Super{
         @Override 
         protected void hookMethod(){
             ...
         }
        
         public Connection getConnection(){
             ...
             return new NConnection();
             // 팩토리 메서드 패턴
         }
     }        
 </code>
 </pre>  

#### 템플릿 메소드 / 팩토리 메소드 패턴 
- 단점 
    1. 상속을 사용했기 때문 ( 다중 상속 불가 ) 
    2. 슈퍼클래스 내부의 변경이 있을 때 모든 클래스의 수정이 필요
    -> 결합도가 여전히 강하다.
- 해결  
    -> 클래스의 분리

### UserDao
1. level1
    - 일반적으로 jdbc api를 사용해서 구현한 userdao
2. level2
    - 반복되는 코드를 리팩토링 했다.
3. level3
    - 팩토리 메소드 / 템플릿 메소드 패턴을 이용했다.  
    즉 상속을 이용해서 서브클래스인 UserDaoLevel에서 슈퍼클래스의 메소드를 오버라이드해서 확장성있게 사용할수 있게 되었다.
4. level4
    - 상속이 아닌 클래스를 분리하면 해결이 될까?
5. level5
    - UserDao와 분리한 클래스 사이에 Interface를 두어 결합도를 낮추었다.
    - UserDao와 결합된 Interface ConnectionMaker의 구현체로 무엇으로 사용했는지 UserDao는 관심이 없다. 

### 원칙과 패턴  
1. 개방 폐쇄 원칙 OCP ( Open Closed Principle )
    - 클래스나 모듈은 확장에 열려있어야 하고 변경에는 닫혀있어야 한다.
    - UserDao는 DB 연결 방법이라는 기능을 확장하는데 열려있다.
    - UserDao 자신의 핵심 기능을 구현한 코드는 변화에 영향을 받지 않는다.
    - h2 db를 mysql db로 교체 한다고 할 때, 다른 코드를 하나도 수정하지 않고 db를 교체할 수 있다.              
    - 높은 응집도, 낮은 결합도  
    -> 응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책임 또는 관심사에만 집중이 되어 있다.  
    -> 결합도는 응집도 보다 더 민감한 원칙이다. 오브젝트 또는 모듈과는 느슨한 연결, 관계를 유지 해야 변화에 대응하는 속도가 높아지고 구성이 깔끔해진다.
       
### 전략 패턴  
> 디자인 패턴의 꽃
- 개선한 UserDaoTest (Class)- UserDaoLevel5 (Class)-  ConnectionMaker (Interface) 구조  
- 자신의 기능 context에서, 필요에 따라 변경이 필요한 알고리즘을 인터페이스를 통해 통째로 외부로 분리시키고,   
    이를 구현한 구현체를 필요에 따라 바꿔서 사용할 수 있게하는 디자인 패턴 
    
### 프레임워크와 라이브러리
*  프레임워크
> 어플리케이션 코드가 프레임워크에 의해 사용된다. 제어가 역전되었다.
* 라이브러리
> 라이브러리를 이용한 애플리케이션 코드는 애플리케이션을 직접 제어한다.

### IOC컨테이너
- DaoFactory 역할을 하는 BeanFactory
-> Bean을 생성, 관계 설정
- ApplicationContext ( IOC 컨테이너 )
-> 빈 팩토리를 확장
 BeanFactory의 구현체를 상속받는 ApplicationContext는 빈의 라이프 사이클을 관리하고
 스프링이 제공하는 각종 부가 서비스를 추가로 제공한다.

※ 빈들을 관리하는 방법 Singleton Scope 또는 Prototype Scope  
-> Prototype Scope는 컨테이너에게 빈을 요청할 때마다 새로운 객체를 생성하여 준다.
※ Object == 와 equals는 동일성 비교, 동등성 비교라 말한다.  
-> 일반 객체가 equals를 구현하지 않았다면 equals는 Object의 equals를 상속받아 동일성 비교를 한다.

### IOC컨테이너에 빈 등록
- 설정정보/ 설정 메타 정보
1. Configuration 
    <pre>
    <code>
    @Conifguation
    public class DaoFactory{
    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker())
    }
    @Bean
    public UserDao userDao{
        UserDao userDao = new UserDao();
        userDao.set(connectionMaker());
        return userDao;
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }    
    </code>
    </pre>
    
- ApplicationContext 구현체 -> AnnotationConfigApplicationContext(//Config.class)
2. xml
    <pre>
    <code>
    @Bean                              ----------------> < bean
    public ConnectionMaker 
    connectionMaker() {                ---------------> id = "connectionMaker"
    return new DConnectionMaker()      ---------------> class = "springbook...DConnectionMaker"/>
    }
    </code>
    </pre>
    - 생성자 주입
        
        <pre>
        <code>
        @Bean                             
        public UserDao userDao{
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());   ---------------> <property name="connectionMaker" ref="connectionMaker"/> 
        return userDao;                                                                   setConnectionMaker(beanId);
        }
        </code>
        </pre>
    - Setter 주입
- ApplicationContext 구현체  
 1. GenericXmlApplicationContext("클래스패스");  
 2. ClassXmlApplicationContext("파일위치",같은 위치에 있는 클래스);  
### 스프링의 싱글톤?
- 일반 싱글톤 패턴과 구현방법이 확연히 다르다.
<pre>
<code>
    public class UserDao{
    
        private static UserDao userDao;
        
        private UserDao(){
        }
        private static synchronized UserDao getInstance(){
            if(userDao==null)userDao = new UserDao(???);
            return userDao;    
        }
    }
    
</code>
</pre>

- 일반 싱글톤 패턴의 문제점
    1. private 생성자를 갖고있기 때문에 상속을 할 수 없다.
    2. 테스트하기가 힘들다.
    3. 서버를 여러개 띄운다 함은 싱글톤 객체가 여러개 만들어진다.
    -> 그러면 이 객체를 싱글톤 객체라 할 수 있을까?
    4. 전역상태를 만들기 때문에 모든 클래스에서 접근할 가능성이 있다.   
- 스프링은 싱글톤 레지스트리 덕분에 싱글톤 방식으로 사용될 어플리케이션 클래스라도 public 생성자를 가질수 있다.

### 의존 관계
- 클래스나 코드에는 런타임시점의 의존관계가 드러나지 않는다.
- 컨테이너나 팩토리 같은 3자가 런타임시에 의존관계를 결정한다. 

### DataSource Interface
- 다양한 방법으로 DB연결과 풀링 기능을 갖춘 많은 DataSource 구현체가 존재
- ConnectionMaker 인터페이스와 목적이 동일하게 getConnection()를 오버라이드해서 사용하면 된다.
- 구현체 : SimpleDriverDataSource, ..