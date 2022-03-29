let h1 = document.querySelector("h1")
console.log("Hello world")

let name = "Khiêm";
console.log(name)

name = 10
console.log(name)

const email="khiem31200@gmail.com"
console.log(email)


let firstName = "Nguyễn"
let lastName="Văn A"
console.log (firstName+" "+lastName)

console.log(`${firstName} ${lastName} Năm nay tôi ${2022-2000}`)

//Function
function func(a,b){
    return a+b
}

let data = func(4.5,5)
console.log(data)
//First class Function
// 1 function có thể gán cho 1 biến => function expression
let sum1 = function (a,b)
{
    return a+b
}
console.log(sum1(5,5))
//Higher order function
// 1 function có thể truyền vào như là 1 tham số cho function khác
// 1 function có thể return về 1 function khác

//arrow function
let sum2 = (a,b) =>a+b
console.log(sum2(4,4))
// Trong ngoặc tròn chứa các biến trong ngoặc nhọn chứ body


function sortMark(mark){
    if (mark>=85){
        console.log("A")
    }else if(mark>=70&&mark<85){
        console.log("B")
    }else if(mark>=40&&mark<70){
        console.log("C")
    }else{
        console.log("D")
    }  
}
function soSanh(a,b){
    if(a>b){
        return a
    }else{
        return b
    }
}
function checker(a){
    if(a<0){
        console.log("Đây là số âm")
    }else if(a>0){
        console.log("Đây là số dương")
    }else
        console.log("Đây là số 0")
}

function chanLe(a){
    if(a%2==0){
        console.log("Đây là số chẵn")
    }else{
        console.log("Đây là số lẻ")
    }
}
function chiaHet35(a){
    if(a%3==0&&a%5==0){
        console.log("Ok")
    }else if(a%3==0){
        console.log("Chỉ chia hết cho 3")
    }else if(a%5==0){
        console.log("Chỉ chia hết cho 5")
    }
}
function checkabc(a,b,c){
    if(c==a+b){
        console.log("ok")
    }else{
        console.log("a+b khác c")
    }
}

function day(day){
    switch (day) {
        case 0:
            console.log("chủ nhật")
            break;
        case 1:
            console.log("Thứ 2")
            break;
        case 2:
            console.log("Thứ 3")
            break;
        case 3:
            console.log("Thứ 4")
            break;
        case 4:
            console.log("Thứ 5")
            break;
        case 5:
            console.log("Thứ 6")
            break;
        case 6:
            console.log("Thứ 7")
            break;
    }
}
function month(month){
    switch (month) {
        case 1:
        case 2:
        case 3:
            console.log("Mùa Xuân")
            break;
        case 4:
        case 5:
        case 6:
            console.log("Mùa Hạ")
            break;
        case 7:
        case 8:
        case 9:
            console.log("Mùa Thu")
            break;
        case 10:
        case 11:
        case 12:
            console.log("Mùa Đông")
            break;
    }
}
function repeatString(string) {
    let s =""
    for(let i=0;i<10;i++){
    s+=string
    }
    console.log(s)
}
function repeatString1(string) {
    let s =""
    for(let i=0;i<10;i++){
    s+=string+"-"
    }
    console.log(s.substring(0,19))
}
sortMark(90)  
soSanh(50,70)
checker(50)
chanLe(50)
chiaHet35(21)
checkabc(3,2,6)
day(2)
month(10)
repeatString("a")
repeatString1("a")