let money =10
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

async function buy(){
    try {
    let res = await buyIPhone()//await chỉ có giá trị khi đi cùng async function
    console.log(res)
    let res1 = await buyAirPod()
    console.log(res1)
    } catch (error) {
        console.log(error)
    }
    return "Đi nhậu"
}
console.log(buy())
buy().then(res=>console.log(res))
    .catch(err=>console.log(err))