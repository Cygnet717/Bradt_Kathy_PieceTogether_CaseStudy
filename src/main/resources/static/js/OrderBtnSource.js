$("#orderButton").click(()=>{
    let acc = $("#accordion")
    let list = $("#eventList")

    if(acc.length === 1){
        acc.toggleClass("reverseOrder")
    }else if(list.length === 1){
        list.toggleClass("reverseOrder")
    }
})