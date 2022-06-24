console.log('settings js connected')

$("#editUserButton").click(()=>{
    $("#settingsForm").removeAttr("disabled")
    $("#settingsFormButton").removeAttr("hidden")
    $("#cancelEditUser").removeAttr("hidden")
    $(":input").removeAttr("disabled")
    console.log('this here')
    $("#editUserButton").attr("hidden", true)
    console.log('that there')
})

$("#cancelEditUser").click(()=>{
    $("#settingsForm").attr("disabled", true)
    $("#settingsFormButton").attr("hidden", true)
    $("#cancelEditUser").attr("hidden", true)
    $(":input").attr("disabled", true)
    $("#editUserButton").removeAttr("hidden")
})