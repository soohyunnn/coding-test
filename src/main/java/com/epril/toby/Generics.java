package com.epril.toby;

import java.util.stream.Collectors;

public class Generics {
    static class Hello<T> {  //T -> type parameter

    }

    void print(String value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        new Hello<String>();   //type argument

    }
}

/*
[제네릭을 사용하는 이유]
1. 컴파시점에서 컴파일러가 정확하게 타입을 체킹을 해주 수 있다는 것
ex)에러 발생 경우
"
List list = new ArrayList();
list.add("str");
Integer s = (Integer) list.get(0);
"
=> 런타임시에만 체크되어 코드를 작성할때는 오류가 나는 코드인지 확인이 안된다.

#row type 이란? 아래와 같이 선언하는 방법을 row type이라고 한다.
List list = new ArrayList<Integer>();

ex)
"
List<Integer> ints = Arrays.asList(1,2,3);
List rawInts = ints;
"
=> 이 경우에는 문제가 생기지 않는다.
=> 하지만 반대의 경우는 Warning이 뜹니다. ("Unchecked or Unsafe operations")
"
List<Integer> ints2 = rawInts;
But => List<String> strs = rawInts;
       String str = strs.get(0); 이때 java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String 에러 발생
"
=> Warning이 안뜨게 하려면 @SuppressWarnings("unchecked")를 코드 바로 위에 붙여주기


[제네릭 메소드]
1. 인스턴스 메소드
public class Generics {
    <T> void print(T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        new Generics().print("Hello");
        new Generics().print(1);
    }
}
=> 실행결과
Hello
1

2. 스태틱 메소드
public class Generics {
    static <T> void print(T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        print("Hello");
        print(1);
    }
}

만약 클래스레벨에서 제네릭을 사용할 경우
public class Generics<T> {
    static void print(T t) {  (X)
         System.out.println(t.toString());
    }

    public static void main(String[] args) {
    }
}
=> 이 경우에는 print 메소드에 static을 사용할 수 없다.
=> 그 이유는 클래스 인스턴스가 만들어질때 인자를 받아오게 됐는데 static 이라는건 Generics 클래스의 오브젝트를 만들지 않고 쓰는거이기때문에 T 타입이 뭐가 될지 몰라 사용 불가능 => 이럴 경우는 당연히 메소드 레벨에서
제네릭을 사용해야 한다.
    아니면 아래와 같이 사용해도 된다.
public class Generics<T> {
    static <S> void print(S s) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {

    }
}

- 생성자의 인자값이 제네릭 사용하는 경우
public <S> Generics(S s) {
}


[Bounded Type Parameter] = 제한된 타입 파라미터
- 타입 파라미터를 줄때는 아무런 조건 없이 주는데 여기에 제한을 주겠다는 것이다.
public class Generics<T extends List> {
    //Bounded Type Parameter
}
=> T는 List의 서브 타입만 가능하다는 의미

- 메서드에서 사용 가능
public class Generics {
    static <T extends List> void print(T t) { }

    public static void main(String[] args) {

    }
}
=> 제약조건은 여러개 줄 수 있다. (아래와 같이)
public class Generics {
    static <T extends List & Serializable & Comparable & Closeable> void print(T t) { }

    public static void main(String[] args) {

    }
}
=> 이를 인터섹션 타입이라고 한다. (List & Serializable & Comparable & Closeable)
=> 람다식에서도 쓸 수 있다.


- 응용 예제
Array를 받고 기준값을 받아서 기준으로 준 값이 큰 것이 Array안에 몇개나 있나 찾아서 return 하는 메소드 구현

public class Generics {
//    static long countGreaterThan(Integer[] arr, Integer elem) {
//        return Arrays.stream(arr_.filter(s -> s > elem).count();
//    }
// 👇아래 1이 해결되도록 변경 (제너릭 메소드로 만들면 됨)

    static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {  //T타입에 comparable 메소드가 있는지 없는지 알수 없어바로 사용 불가능
                                                                                 //static <T> long  => static <T extends Comparable<T>> long 으로 제한을 준다.
        return Arrays.stream(arr).filter(s -> s.comparaTo(elem) < 0).count();  //Comparable 인터페이스를 사용! s는 컴파일러 뿐만 아니라 런타임시에도 Comparable 인터페이스를 구현한 타입이라는 것을 안다.
    }


    public static void main(String[] args) {
//        Integer[] arr = new Integer[] {1,2,3,4,5,6,7};
//        System.out.println(countGreaterThan(arr, 4);
        // --1👇
        //String 안에 Comparable가 구현되어 있다.
        String[] arr = new String[] {"a", "b", "c", "d", "e"}; 으로 할 경우 아래에서 에러 발생 => Generic 메소드로 정의하면 해결  --1
        System.out.println(countGreaterThan(arr, "b"));
    }
}
=> 무한대의 타입을 다 처리할 수 있는 제너릭한 메소드면서도 이 안에 알고리즘을 적용하는 꼭 필요한 타입 조건을 걸고 싶을 때 Bounded Type Parameter를 쓴다.


[제네릭과 상속]
public class Generics {
    public static void main(String[] args) {
        Integer i = 10;
        Number n = i;  //Number가 Integer의 슈퍼클래스이기 때문에 가능하다.(Integer는 Number의 서브 타입이다.)

        List<Integer> intList = new ArrayList<>();
//        List<Number> numberList = intList;  //=> 컴파일 에러 발생 WHY? List<Integer>는 List<Number>의 서브 타입이 아니다.

        ArrayList<Integer> arrList = new ArrayList<>();
        List<Integer> intList2 = arrList;   //=> OK , List<Integer>타입은 ArrayList<Integer> 타입의 슈퍼타입이다.!!

    }
}

👇 예제
public class Generics {
    static class MyList<E, P> implements List<E> {
        ...
    }

    public static void main(String[] args) {
        List<String> s1 = new MyList<String, Integer>();  //OK , 타입 파라미터가 뒤에 어떻게 붙냐는 상관이 없습니다.
        List<String> s2 = new MyList<String, String>();   //OK
    }

}

[타입 추론(Type Inference)]
- 메소드 호출할 때 정보를 보고 타입 아규먼트가 무엇을 들어가야 하는지 체크를 해주는 기능을 한다.
public class Generics {
    static <T> void method(T t, List<T> list) {

    }

    public static void main(String[] args) {
        Generics.method(1, Arrays.asList(1,2,3));
        Generics.<Integer>method(1, Arrays.asList(1,2,3));  // method의 첫번째 파라미터의 타입은 Integer라고 알려주는 것이다.
    }

}
=> T 타입이 뭔지 컴파일러가 알아서 찾아서 사용한다.(체크를 자동으로!!)

👇 자바 7부터 적용
public class Generics {
    static <T> void method(T t, List<T> list) {

    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();  //타입 추론 중 하나!
        List<String> c = Collections.emptyList();   //String 타입의 빈 리스트구나 하고 알아서 판단을 해준다.
        List<String> c = Collections.<String>emptyList();   //만약 자바 6나 다른버전에서 안되면 명시적으로 타입을 적어주면 됩니다.
    }

}



[wildcards란?]
public class Generics {
    //1.
    static <T> void method(List<T> t) {

    }

    //2.
    static void method(List<?> t) {  //?를 wildcards 라고 한다.(내가 이 타입을 모른다! 라는 의미)

    }

    public static void main(String[] args) {

    }

}
=> 1과 2의 차이점은?
둘 다 개념은 비슷합니다.
2는 "Object 클래스에 정의된 기능만 가져다 사용하겠다." 라는 의미이다. 그리고 "나는 이안에 타입이 오든지 뭐든 상관없다"라는 의미이다.
    => List가 가지고 있는 메서드만 사용하겠다는 의미이다. (size(), clear()) , add()는 사용X


public class Generics {
    //1.
    static void printList(List<Object> list) {
        list.forEach(s -> System.out.println(s));
    }

    //2.
    static void printList2(List<?> list) {              //List<? extends Object> 로 해도 에러 X
        list.forEach(s -> System.out.println(s));
    }

    public static void main(String[] args) {
        //1과 2의 차이점은??
        printList(Arrays.asList(1,2,3));
        printList2(Arrays.asList(1,2,3));
        //=> 위의 2개의 코드는 문제가 없다.

        //BUT 어떠한 타입 파라미터를 갖는다고 설정을 해주면 에러가 납니다.
        List<Integer> list = Arrays.asList(1,2,3);
//        printList(list);  //=> 이 경우에는 에러 발생,  WHY? List<Integer>는 List<Object>의 서브타입이 아니라서!
        printList2(list);  //=> OK, ?로 선언했기때문에 에러 발생 X
    }

}


public class Generics {
    static class A {}
    static class B extends A {}

    public static void main(String[] args) {
        List<B> listB = new ArrayList<B>();
        //List<A> la = listB;  //에러
        List<? extends A> la = listB; //OK
        List<? super B> l2 = listB;  //super은 extends의 반대, 앞에 나오는 타입이 뒤에 나오는 타입의 슈퍼타입이어야 하는 것을 의미
        //List<? super A> l2 = listB;  //에러

        👇 BUT 제약이 생긴다.
//        la.add(new A());  //에러 발생
//        la.add(new B());  //에러 발생  => null밖에 넣을 수 없다.
        listB.add(new B());  //OK
    }
}

[!! wildcards의 제약성과 유효성을 잘 알고 써야한다. (쓰고 안쓰고의 차이점)]

<2탄>
public class Generics {
    //1.제네릭
    static <T> void method1(List<T> list) {
        T t;
    }

    //2.whildcard
    static void method2(List<?> list) {
        //사용할 수 있는 것들 전부....
        list.add(null);  //null만 넣을 수 있다.
        list.size();
        list.clear();
        Iterator<?> it = list.itertor();
        list.equlas();
    }

    //========================================
    //ex)예제 1
    //1.제네릭
    static <T> boolean isEmpty(List<T> list) {
        return list.size() == 0;
    }

    //제네릭 -> whildcard로 변경
    //2.와일드카드
    static boolean isEmpty(List<?> list) {
        return list.size() == 0;
    }

    //ex)예제 2
    //1.제네릭
    static <T> long frequency(List<T> list, T elem) {
        //elem이 list에 몇개가 있는지 확인하는 메소드
        return list.stream().filter(s -> s.equals(elem)).count();  //equals가 true인 것만 가져와서 count한다!
    }

    //제네렉 -> 와일드카드로 변경
    //2. 와일드카드
    static long frequency(List<?> list, Object elem) {  //elem은 ?로 하면 오류, 와일드카드는 타입 파라미터를 정의하는 부분에만 들어갈 수 있다. 이 경우에는 Object로 해야 한다.
        return list.stream().filter(s -> s.equals(elem)).count();  //equals는 Object 클래스 안에 있어 사용이 가능!
    }

    //ex)예제 3
    //1. 제네릭
    private static <T extends Comparable<T>> T max(List<T> list) {
        //reduce()는 원소 2개를 받아서 그 결과를 리턴하게 하는 것(
        // 첫번째 방법 .identity : 초기값을 미리 잡아놓고 첫번째 원소랑 연산를 하고 그 결과로 두 번째 원소랑 연산을 하고 최종까지 가는 것
        // 두번째 방법 .BinaryOpertator : 원소 2개를 받아서 그 결과를 리턴하게 하는 것, 초기값 따로 없이 첫번째 두번째로 먼저 연산을 하는 방식, 첫번째꺼가 초기값이 되는 방식)

        //만약 list에 빈 값을 보내면 .get()에서 NoSuchElementException 에러가 발생한다.
        return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();  //결과값이 없을 수도 있어 Optional로 결과값이 나온다. => get()으로 가져온다.
    }

    //제네렉 -> 와일드카드로 변경
    //2. 와일드카드
    //상위한정, 하위한정은 자바 문서를 보면 잘 나옴(참고!!)
    //? super T : 하위 제한 : 메소드 밖에서 무언가를 사용할 수 있다는 것
    //? extends T : 상위 제한, 파라미터의 값이 메소드 내에서 사용을 위해 넘겨지는 값이라면 상위한정을 쓸 수 있다.
    //자바의 Collections.max()와 동일한 것이니 참고하기!
    private static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();
    }


    public static void main(String[] args) {
        //ex)예제 1
//        List<Integer> list = Arrays.asList();
//        System.out.println(isEmpty(list));  //true

        //ex)예제 2
//        List<Integer> list = Arrays.asList(1,2,3,4,5,3,2);
//        frequency(list, 3);  //2

        //ex)예제 3
        List<Integer> list = Arrays.asList(1,2,3,4,5,3,2);  //1만 보낼 경우 return 값은 1이 된다.
        System.out.println(max(list));  //5
        System.out.println(Collections.max(list, (a,b) -> a - b));  //위에서 만든 예제3 max 메소드와 동일한 결과가 나온다. => 5
        System.out.println(Collections.max(list, (Comparator<Object>)(a,b) -> a.toString().compareTo(b.toString())));  //Comparator<Object>로 캐스팅! => 5
        System.out.println(Collections.<Number>max(list, (Comparator<Object>)(a,b) -> a.toString().compareTo(b.toString())));  //T타입은 Number가 되고, Number는 Integer의 상위타입


    }
}
제네릭 메소드를 쓰는 이유 : 타입 파라미터로 정의된 list로 치자면 그 안의 원소(엘리먼트)에 대해 관심이 있다는 것이다. add()한다, remove()한다, set()을 한다. 등등
와일드카드 쓰는 이유 : 타입이 뭔지 관심없고 list가 가지고 있는 메소드를 사용하겠다는 것이다. list의 기능만 사용할 경우 와일드카드로 사용이 가능하다. Object 클래스안에 정의되어 있는걸 사용하는건 허용이 되여 와일드카드로 작성이 가능하다.

Q. 예제1과 예제2 모두 제네릭과 와일드카드로 모두 작성이 가능한데 이 중 어느걸로 사용하는 것이 더 좋을까?
A. 와일드카드로 작성하는 것이 좋다. 자바의 설계된 사상을 잘 따라서 코드를 작성하려면 와일드카드로 쓰는것이 맞다.
    제네릭으로 정의하는 경우 옳지 않다고 한다. => <T>를 사용하여 메소드를 만들면 메소드안에서 T타입으로 무언가를 구현을 하겠다고 코드상에서 해석이 된다고 한다. (내부 구현이 노출됨)
                                    => API를 설계한 사람의 입장에서 API 코드 구현의 의도를 잘 표현하지 못했다고 한다.

예를 들어 Comparable에 해당하는 것만 사용하겠다 하면 와일드 카드를 사용해도 상관이 없다. (Comparable이 구현한 메소드까지만 사용하겠다 하면 이렇게 와일드 카드로 쓰면 된다.)
=> 이걸 구현한 타입 T에 관심이 있다 하면 제네릭 메소드를 사용해야 한다.
static boolean isEmpty(List<? extends Comparable> list) {  //=> extend하는걸 upper bound라고 한다.
    return list.size() == 0;
}



[와일드카드 캡처]
public class Generics {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        reverse(list);
        System.out.println(list);  //[5, 4, 3, 2, 1]
    }

    //1.제네릭
    static <T> void reverse(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        for(int i = 0; i < list.size() ;i++) {
            list.set(i, temp.get(list.size()-i-1));  //인덱스가 0부터 시작하니까 -1을 더 해줘야 한다.
        }
    }

    //제네릭 -> 와일드카드로 변경
    //2.와일드카드
    static void reverse(List<?> list) {
        List<?> temp = new ArrayList<>(list);
        for(int i = 0; i < list.size() ;i++) {
            list.set(i, temp.get(list.size()-i-1));  //temp.get(list.size()-i-1)에서 에러 발생(캡쳐 에러...)
        }
    }
    //=> 와일드카드로 만든건 캡처 프로세스가 돌아가는 경우가 있다. 필요에 따라 타입이 뭔지 추론을 해내는 상황이 있는데 이때를 캡처라고 한다.
    //캡처가 필요로 하는 상황을 만나서 캡처가 안되면 위와 같은 에러가 발생한다.(타입을 명확히 하지 않아 캡처 에러 발생)
    //해결방법 1 : 제네릭 메소드로 바꾸기
    //❣️해결방법 2 : 강제로 캡처하는 헬퍼메소드를 생성 👇reverse를 아래 2개로 분리
    static void reverse(List<?> list) {
        reverseHelper(list);
    }

    private static <T> void reverseHelper(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        for(int i = 0; i < list.size(); i++) {
            list.set(i, temp.get(list.size()-i-1));
        }
    }
    //=> 와일드카드로 만든 파라미터를 제네릭으로 받는데 문제가 없다. WHY? 와일드카드가 적용된 List타입을 컴파일러가 제네릭 타입으로 캡처를 해준다.
    //❣️해결방법 3. Collections 에서 사용하는 방법
        static void reverse(List<?> list) {
            List temp = new ArrayList<>(list);  //row타입으로 변경
            List list2 = list;
            for(int i = 0; i < list.size() ;i++) {
                list2.set(i, list2.get(list2.size()-i-1));
            }
         }

}

[인터섹션 타입(Multiple bound) 활용하는 방법 - Generic Type Intersection]
👇 람다식 예시
public class IntersectionType {

    public static void main(String[] args) {
        //아래 4가지는 모든 같은 코드를 의미한다.
        //1.
        hello(s -> s);    //메소드 하나의 인터페이스이다. 해당 인터페이스를 구현한 메소드 코드이다.
        👇
        //2.
        Function<String, String> f = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        }
        hello(f);
        👇 하나로 합치기
        //3.
        hello(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });
        //4.
        👇 람다식으로 변경
        hello((String s) -> {
                return s;
            }
        });
        👇 호출하는 메소드의 파라미터에 타입이 정해져 있어 타입도 정의하지 않아도 된다. {}이랑 ;도 필요없어 지우면 1번과 같은 코드가 나온다.
        hello((s) ->
                return s;
        });
    }

    private static void hello(Function<String, String> o) {

    }

}

=> @FunctionalInterface란 ? Interface인데 메소드가 딱 하나만 있으면 FunctionalInterface
=> Function는 @FunctionalInterface이다.


👇 인터섹션 타입
public class IntersectionType {
    public static void main(String[] args) {
        //Closeable을 추가로 캐스팅 하면 에러 => 메소드를 1개 가지고 있다.
        //Cloneable 추가 가능 =>메소드를 0개 가지고 있다. (Function & Serializable & Cloneable) => 타입 조건이 3가지를 다 받을 수 있도록 작성된다.
        hello((Function & Serializable)s -> s);  //Function & Serializable로 캐스팅했을 때 메소드 갯수가 1개면 되므로 문제 없다.(Function에 메소드 1개, Serializable에 메소드 0개)
    }

    //public static <T extends Function & Serializable & Cloneable> void hello(T o) {} 도 가능
    public static void hello(Function o) {  //Function대신 Serializable나 Cloneable도 받는것도 가능

    }

}
=> 인터섹션 타입은 타입을 여러개 주고 전체를 다 만족한다는 타입을 의미한다.
=> 인터섹션 타입은 람다식을 넘기는데도 사용이 가능하다.

[자바8에서 추가된 upper bound에 intersection 타입 사용]
- intersection type : 새로운 클래스를 정의하지 않은 채, 여러개의 인터페이스를 조합한 익명 타입 구현 가능
import java.io.Serializable
import java.util.function.Function;

public class IntersectionType {
    interface Hello {
        default void hello() {   //default 메소드는 인터페이스 안에 구현 코드를 넣을 수 있게 해주는 것, java8에서는 무조건 public, 9부터는 private 가능
            //필드 정의 불가능
        }
    }

    public static void main(String[] args) {
        hello((Function & Serializable & Cloneable) s -> s);
    }

    // intersection type
    private static <T extends Function & Serializable & Cloneable> void hello(T o) {
    }

}

[Lamda식의 타입에 intersection type을 적용했을 경우. induction 과정을 거쳐서 메소드가 1개라면, 최종적으로는 인터페이스 1개짜리 intersection type이 된다.]
public class IntersectionType {
    interface Hello extends Function {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi extends Function {
        default void hi() {
            System.out.println("Hi");
        }
    }


    public static void main(String[] args) {
        hello((Function & Hello & Hi) s -> s);
    }

    //T에 적용된 타입이 여러개가 된다.
    private static <T extends Function & Hello & Hi> void hello(T t) {  //T는 default 메소드를 다 가지고 있는 하나의 Object 타입으로 되어 모든걸 다 쓸 수 있게 된다.
        t.hello();   //=> Hello
        t.hi();      //=> Hi
    }
}
=> 호출을 받는데에서 일일이 써줘야 해서 불편하다.(<T extends Function & Hello & Hi> 이런식으로) 그래서 콜백방식으로 하면 편리하다.
=> 👇그래서 run() 메소드를 생성


import java.awt.print.PrinterGraphics;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType {
    interface Hello extends Function {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi extends Function {
        default void hi() {
            System.out.println("Hi");
        }
    }

    interface Printer {
        default void print(String str) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        run((Function & Hello & Hi & Printer) s -> s, o -> {
            o.hello();
            o.hi();
            o.print("Lamda");
        });
    }

    private static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
=> 람다식에 적용되는 FunctionalInterface는 이 안에 구현되야 할 메소드 정의가 1개라는 뜻입니다. default까지 포함해서 전체가 1개라는 것이 아니라 static메소드와 default 메소드를 제외하고! 일반적인 메소드의 갯수만 합친것
=> 그래서 (Function & Hello & Hi & Printer)가 문제가 없다.
=> 이런식으로 Object에 기능을 계속해서 추가해 나갈 수 있다.
👇 <자바8에 있음>
=> Consumer은 return은 없고 파라미터만 받는것, Supplier은 return은 있고 파라미터가 없는것(서로 반대)
=> Function은 return도 있고 파라미터도 있는것, BiFunction은 return도 있고 파라미터도 2개 있는 것


- 람다식의 어떤 타입은 인터섹션 타입을 적용했을 때 이 안에 있는 모든 타입은 induction 과정을 다 거쳤을 때 메소드가 1개이면 됩니다.
- Function & Hello & Hi & Printer를 모두 합쳤을 떄 메소드가 1개이면 되므로 Hello에서 extends Function 했다고 메소득 1개 생겼다고 에러가 발생하지는 않는다.


👇 실제로 이걸 어떻게 활용하는가???
public class IntersectionType {
    interface DelegateTo<T> {
        T delegateTo();
    }

    interface Hello extends DelegateTo<String> {  //여기서 main()에서 DelegateTo을 구현한 코드를 호출하게 된다.
        default void hello() {
            System.out.println("Hello " + delegate());
        }
    };

    //람다식에 캐스팅에 IntersectionType만 추가하고 싶어 추가한 Interface
    //DelegateTo로 넘어온 문자를 대문자로 바꿔주는 기능을 하는 인터페이스
    interface UpperCase extends DelegateTo<String> {
        default void upperCase() {
            System.out.println(delegate().toUpperCase());
        }
    }

    public static void main(String[] args) {
        run(DelegateTo<String> & Hello & UpperCase)()-> "Daniel Jung", o -> {   //DelegateTo을 실제 구현한 코드
            o.hello();          //=> "Hello Daniel Jung" 출력
            o.upperCase();      //=> "DANIEL JUNG" 출력
        });
    }

    private static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {  //이미 T타입을 쓰고 있기에 DelegateTo는 S로 정의, 타입파라미터를 2개 가지고 있다는 것을 의미
        consumer.accept(t);
    }
}


👇 [class에 동적으로 기능을 추가하기 위한 intersection type의 사용]
=> Pair 클래스에 기능을 추가하도록 구현한 예제(UpperCase기능과 print기능 추가), 내장 메소드인것처럼 기능을 추가

import java.awt.print.PrinterGraphics;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType {

    //Pair 인터페이스
    interface Pair<T> {
        T getFirst();
        T getSecond();
        void setFirst(T first);
        void setSecond(T second);
    }

    //Pair를 구현한 클래스
    static class Name implements Pair<String> {
        String firstName;
        String lastName;
        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        @Override
        public String getFirst() {
            return null;
        }
        @Override
        public String getSecond() {
            return null;
        }
        @Override
        public void setFirst(String first) {
            this.firstName = first;
        }
        @Override
        public void setSecond(String second) {
            this.lastName = second;
        }
    }

    //DelegateTo<Pair<T>>의 메소드를 호출 했을 때 거기서 넘어오는 Object에 아래와 같은 코드를 실행 할 수 있도록 포워딩시켜주는 인터페이스이다.
    interface ForwardingPair<T> extends DelegateTo<Pair<T>>, Pair<T> {
        //Override 대신 default 로 구현!
        //=> Override로 구현하면 메소드의 개수가 4개가 늘어나 run()메소드에 람다식으로 쓸 수 가 없어지기 때문에(람다식의 타입캐스팅에 쓸 수 가 없다)
        default T getFirst() { return delegate().getFirst(); }
        default T getSecond() { return delegate().getSecond(); }
        default void setFirst(T first) { delegate().setFirst(first); }
        default void setSecond(T second) { delegate().setSecond(second); }
    }

    interface DelegateTo<T> {
        T delegate();
    }

    private static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    interface Convertable<T> extends DelegateTo<Pair<T>> {
        default void convert(Function<T, T> mapper) {
            Pair<T> pair = delegate();
            pair.setFirst(mapper.apply(pair.getFirst()));
            pair.setSecond(mapper.apply(pair.getSecond()));
        }
    }

    //결과를 출력하기 위한 인터페이스 정의
    interface Printable<T> extends DelegateTo<Pair<T>> {
        default void print() {
            System.out.println(delegate().getFirst() + " " + delegate().getSecond());
        }
    }

    static <T> void print(Pair<T> pair) {
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }

    public static void main(String[] args) {
        Pair<String> name = new Name("Toby", "Lee");
        run((ForwardingPair<String> & Convertable<String> & Printable<String>)() -> name, o -> {
            o.print();  //Toby Lee
            o.convert(s -> s.toUpperCase());
            o.print();  //TOBY LEE
            o.convert(s -> s.subString(0,2));
            o.print();  //TO LE
       });
    }
}











*/



