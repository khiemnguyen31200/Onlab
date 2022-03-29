//Array
let arr = []
arr[0] = "Hello"
arr[1] = true
arr[2] = 10
console.log(arr)


let numbers = [1, 2, 3, 4, 5]
console.log(numbers)
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i])
}
let total = 0
for (let i = 0; i < numbers.length; i++) {
    total += numbers[i]
}
console.log(total)
numbers.forEach(function (value, index) {
    console.log(`${value}-${index}`);
})

//Arrow function
let sum = 0
numbers.forEach((value, index) => {
    sum += value
    console.log(`${value}-${index}-${sum}`);
})

let arr1 = [1, 2, 3]
let arr2 = [1, 2, 3]
let text = "1,2,3"

console.log(arr1 == arr2)
console.log(arr1 != arr2)
console.log(arr1 == text)
//Trả về so sánh theo giá trị từ nhỏ đến lớn
console.log(arr.sort((a, b) => a - b))
//map
let numbers1 = [1, 2, 3, 4]
let newArr = []
for (let i = 0; i < numbers1.length; i++) {
    newArr[i] = numbers1[i] * 2;
}
let newArr2 = numbers1.map(e => e * 2)
//filter
//Lọc giá trị có điều kiện
let arr0dd = numbers1.filter(e => e % 2 == 1)
console.log(arr0dd)
//find
//Tìm giá trị đầu tiên nó nhìn thấy
let firstOddNumber = numbers.find(e => e % 2 == 1)
console.log(firstOddNumber)
//findIndex
//Chỉ số đầu tiên nhìn thấy
let indexFirstOddNumber = numbers.findIndex(e => e % 2 == 1)
console.log(indexFirstOddNumber)
//Some
//Nếu 1 phần tử thỏa mãn điều kiện trả về true còn tất cả không thỏa mãn điều kiện trả về false
console.log(numbers1.some(e => e > 5))
//Every
//Nếu 1 phần tử không thỏa mãn điều kiện trả về false còn tất cả  thỏa mãn điều kiện trả về true
console.log(numbers1.every(e => e > 0))


function maxArr() {
    let newArrw = numbers1.sort((a, b) => b - a)
    return newArrw[0]
}
console.log(maxArr())

function repeatArr() {
    let fillArr = []
    for (let i = 0; i < 10; i++) {
        fillArr[i] = "a"
    }
    return fillArr.join("")
}
console.log(repeatArr())

function repeatArr2() {
    let fillArr = []
    for (let i = 0; i < 10; i++) {
        fillArr[i] = "a-"
    }
    return fillArr.join("").substring(0, 19)
}
console.log(repeatArr2())
function sodu(arr) {
    let newArrw2 = []
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 0) {
            newArrw2[i] = 0
        } else {
            newArrw2[i] = 1
        }
    }
    return newArrw2
}
console.log(sodu([1, 2, 3, 4]))

function elementExist(sortArr, number) {
    for (let i = 0; i < sortArr.length; i++) {
        if (sortArr[i] == number) {
            return true
        }
    }
    return false
}
console.log(elementExist([1, 2, 3], 5))

function elementGreater(sortArr, number) {
    let greater = []
    for (let i = 0; i < sortArr.length; i++) {
        if (sortArr[i] > number) {
            greater[i] = sortArr[i]
        }
    }
    return greater.filter(ele => ele > 0)
}
console.log(elementGreater([1, 2, 3, 5, 7, 9], 3))
// object 
let user = {
    name: "Nguyễn Văn A",
    age: 23,
    email: "abc@gmail.com",

    sayhello() {
        console.log("Xin chào")
    },

    eat(food) {
        console.log(`Ăn món ${food}`)
    }
}
//Truy cập các thuộc tính
console.log(user.name)
console.log(user.age)
user.sayhello
user.eat("Bún")

//Set lại các giá trị
user.name = "Ngô B"
console.log(user)

//Lặp object 
let keys = Object.keys(user)
for (let i = 0; i < keys.length; i++) {
    console.log(user[keys[i]])
}

for(let key in user){
    console.log(user[key])
}


let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 1. In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
// Tên - Giá - Thương Hiệu - Số lượng
// Ví dụ : OPPO Find X3 Pro - 19500000 - OPPO - 3
function displayInfo(arr){
    arr.forEach(product=>{
        console.log(`${product.name}-${product.price}-${product.brand}-${product.count}`)     
    })
}
displayInfo(products)

// 2. Tính tổng tiền tất cả sản phẩm trong giỏ hàng
function calTotalMoney(arr){
    let sum =0
    arr.forEach(product=>{
        sum+= product.price*product.count
    })
    return sum
}
console.log(calTotalMoney(products))
// Tổng tiền mỗi sản phẩm = price * count

// 3. Tìm các sản phẩm của thuơng hiệu "Apple"
function findByBrand(arr,brandName){
    return arr.filter(product => product.brand.toLowerCase()==brandName.toLowerCase())
}
console.log(findByBrand(products,"Apple"))

// 4. Tìm các sản phẩm có giá > 20000000

function findByPrice(arr, price){
    return arr.filter(product=>{product.price>price})
}


// 5. Tìm các sản phẩm có chữ "pro" trong tên (Không phân biệt hoa thường)
function findByName(arr,name){
    return arr.filter(product=>product.name.toLowerCase()==name.toLowerCase())
}
console.log(products,"PRO")

