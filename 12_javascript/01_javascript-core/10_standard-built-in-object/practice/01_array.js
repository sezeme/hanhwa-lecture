// 1. 배열
// 1-1
const str = '사과,바나나,당근,김밥,치즈,떡볶이,햄버거,환타,사이다,콜라,고양이,강아지';

console.log(findWord(str, '고양이'));
console.log(findWord(str, '샌드위치'));
console.log(findWord(str));

function findWord(str, word) {
    const arr = str.split(",");
    if (word === undefined) {
        return "결과를 확인할 수 없습니다.";
    }
    if (str.includes(word)) {
        return `${word}는 배열 index ${arr.indexOf(word)}번째에 있습니다.`;
    } else {
        return `${word}는 배열에 존재하지 않습니다.`;
    }
}

// 1-2
function filterRange(arr, a, b) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < a || arr[i] > b) {
            arr.splice(i, 1);
            i--;
        }
    }
}

const arr = [5, 3, 8, 1, 10, 4];

filterRange(arr, 1, 5);

console.log(arr);

// 1-3
let numbers = [20, 100, 37, 54, 88, 9];
let strings = ['wow', 'js', 'party', 'hello'];

// 코드 작성
numbers.sort((a, b) => a - b);
console.log(numbers);
numbers.sort((a, b) => b - a);
console.log(numbers);

strings.sort();
console.log(strings);
strings.sort().reverse();
console.log(strings);

// 1-4
function Student(firstName, lastName, score) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
}

const studentList = [
    new Student('길동', '홍', 60),
    new Student('보고', '장', 70),
    new Student('관순', '유', 80)
];

sortFromScore(studentList);
console.log(studentList);
console.log(makeFullName(studentList));

function sortFromScore(arr) {
    arr.sort((a, b) => b.score - a.score);
}

function makeFullName(arr) {
    arr.forEach(elem => {
        /*
        * return arr.map(user => ({
          name : user.lastName + user.firstName,
          score : user.score })
          );
        * */
        elem.name = elem.lastName + elem.firstName;
        delete elem.firstName;
        delete elem.lastName;
    });
    return arr;
}

