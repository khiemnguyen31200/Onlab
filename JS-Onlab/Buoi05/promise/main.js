//Promise

// Hứa : Cuối năm có năm có đủ 40 củ mua Iphone 14 Pro Max

let money =45
function buyIPhone(){
    return new Promise(function(reslove, reject){
        if(money>40){
            reslove("Mua IPhone")
        }else{
            reject("Nghỉ")
        }
    })
}

//Hứa tiếp : Mua iPhone còn tiền thì mua AirPod (4 Triệu)
function buyAirPod(){
    return new Promise(function(reslove,reject){
        if(money-40-4>=0){
            reslove("Mua Airpod")
        }else{
            reject("Nghỉ")
        }
    })
}
//Thực hiện nối tiếp
// buyIPhone()
//     .then(res =>{
//         console.log(res)
//         return buyAirPod()
//     })
//     .then(res => {
//         console.log(res)
//     })
//     .catch(err =>{
//         console.log(err)
//     })
//     .finally(()=>{//Finally luôn luôn được thực hiện
//         console.log("Đi nhậu")
//     })

// Thực hiện song song
// buyIPhone()
// .then(res =>{
//     console.log(res)
// })
// .catch(err =>{
//     console.log(err)
// })

// buyAirPod()
// .then(res =>{
//     console.log(res)
// })
// .catch(err =>{
//     console.log(err)
// })

//Hoặc
 Promise.all([buyIPhone(),buyAirPod()])
 .then(res=>console.log(res))
 .catch(err=>console.log(err))