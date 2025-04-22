// 생성자 오버라이딩
class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }
}

/* 다른 클래스를 상속 받고 constructor 를 선언하지 않으면 비어있는 생성자가 만들어 진다.
* class Tiger extends Animal {
*   constructor(...args) {
*       super(...args);
*   }
* }*/

class Deer extends Animal {
    constructor(name, weight, legLength) {
        // 상속 클래스의 생성자에서는 반드시 부모 클래스의 생성자를 호출하는 구문이 들어가야 한다.
        super(name, weight);
        this.legLength = legLength;
    }
}








