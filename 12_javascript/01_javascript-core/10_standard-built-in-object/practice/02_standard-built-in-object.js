// 2-1
console.log(getWeekDay(2022, 6, 21));       // 2022년 6월 21일
console.log(getWeekDay(2022, 12, 12));      // 2022년 12월 12일

function getWeekDay(year, month, date) {
    // 코드 작성
    const when = new Date(year, month - 1, date).getDay();
    const weekday = ['일', '월', '화', '수', '목', '금', '토'];
    return weekday[when];
}

// 2-2
console.log(getSecondsToday());
console.log(getSecondsToTomorrow());

function getSecondsToday() {
    const now = new Date();
    const startOfDay = new Date(now.getFullYear(), now.getMonth(), now.getDate());
    const diff = now - startOfDay;
    return `${Math.round(diff / 1000)}초나 흘렀습니다. 시간을 소중히 씁시다^^`;
}

function getSecondsToTomorrow() {
    const now = new Date();
    const startOfTomorrow = new Date(now.getFullYear(), now.getMonth(), now.getDate()+1);
    const diff = startOfTomorrow - now;
    return `${Math.round(diff / 1000)}초 밖에 안 남았습니다. 다시는 오지 않는 오늘입니다^^`;
}

// 2-3
let arr = ["1080px", "$100", "+200", "60kg", "6m", "-15"];
console.log(removeChar(arr));

function removeChar(arr){
    return arr.map(item => {
        const cleaned = item.replace(/[^0-9.-]+/g, '');
        return Number(cleaned);
    })
}

// 2-4
const list = ['기러기', '토마토', '스위스', '인도인', '별똥별', '우별림'];

list.forEach(item => console.log(palindrom(item)));

function palindrom(str) {
    return str === str.split('').reverse().join('');
}
