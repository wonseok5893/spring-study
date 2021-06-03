# AOP를 이용한 Cache 원리 이해

### 관심사의 분리와 AOP


* 적절한 예시는 아니지만, FirstName 성으로 유저들 조회하는 API 호출시 Controller 계층에서 다음과 같은 로직을 수행한다고 하자
 
<pre>
<code>
    userService.getUsers("최");
    
    public List<User> getUsers(String firstName){
        1. 검색한 firstName 성으로 캐싱되어있는 정보가 있는지 확인
        2. 없으면 DB query 수행
    }
</code>
</pre>

SRP 원칙을 따르지 못하고 있다. 
1. 캐싱 
2. 비지니스 로직 

이를 분리하기 위해 AOP를 적용해보자


