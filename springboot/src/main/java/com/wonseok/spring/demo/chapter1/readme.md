#### 제어의 역전과 의존관계 주입

 1. 인터페이스를 이용한 느슨한 결합, 외부로부터 객체를 주입받아 사용  
   ->  구체적인 클래스를 알 필요가 없음, 유지보수의 간결화
 
#### 분리와 확장을 고려한 설계
 > SoC = 관심사의 분리 
 프로그래밍의 기초 개념 - SoC 

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

            
> 전략 패턴