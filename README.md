Java 기초 문법
---
## 1.length() vs length
- length(): 문자열의 길이를 반환하는 메서드
```
String str = "hello";
System.out.println(str.length()); // 5
```
- length: 배열의 길이를 반환하는 속성
```
int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr.length); // 5
```

## 2. 배열 vs 리스트
- 배열: 크기가 고정되어 있고, 한번 생성한 배열은 크기를 변경할 수 없음. 반드시 처음부터 크기를 지정해야 함.
- 배열의 길이를 알고 싶을 때는 length 속성을 사용
- 값 저장 시 인덱스를 사용
```
int[] arr = {1, 2, 3};
System.out.println(arr.length); // 3

int[] arr = new int[3];
arr[0] = 1;
arr[1] = 2;
arr[2] = 3;
```

- 리스트: 동적으로 크기가 관리되는 배열. 크기를 동적으로 변경할 수 있음.
- 리스트의 길이를 알고 싶을 때는 size() 메서드를 사용
- 값 저장 시 add() 메서드를 사용
```
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
System.out.println(list.size()); // 2
```

## 3. 문자열 변환
- 문자열을 정수로 변환
```
String str = "123";
int num = Integer.parseInt(str);
System.out.println(num); // 123
```

- 정수를 문자열로 변환
```
int num = 123;
String str = Integer.toString(num);
System.out.println(str); // "123"
```

## 4. 배열을 리스트로 변환
- 배열을 리스트로 변환
```
int[] arr = {1, 2, 3};
List<Integer> list = Arrays.asList(1, 2, 3);
```
