// getter, setter
class Product {
    constructor(name, price) {
        // setter 메소드를 호출한다.
        this.name = name;
        this.price = price;
    }
    /* getter, setter 내부에서는 _name, _price 로 실제 값에 접근한다.
    * 만약 그냥 접근하게 되면 해당 코드는 getter, setter를 호출하게 된다. */

    // getter 함수
    get name() {
        console.log('get name 동작');
        return this._name;
    }
    get price() {
        console.log('get price 동작');
        return this._price;
    }
    // setter 함수
    set name(value) {
        console.log('set name 동작');
        this._name = value;
    }
    set price(value) {
        console.log('set price 동작');
        this._price = value;
    }

}

let phone = new Product('전화기', 23000);
console.log(phone.name, phone.price);

