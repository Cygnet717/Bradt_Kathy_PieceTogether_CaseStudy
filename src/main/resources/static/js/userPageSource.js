
console.log("connected to user page source.js")

const extraInputs = $("#extraInputs")

const adjustModalForm = (action) => {
    let selectedVal = $('#selectEventType').val()
    $('#modalHeader').text(`${action} ${selectedVal} Event`)

    $("#eventId").val()
    $("#title").val()
    $("#startDate").val()
    $("#endDate").val()
    $("#notes").val()

    if(selectedVal === 'Job'){
        $('#newEventForm').attr("action", "/event/jobs")
        extraInputs.empty()
        extraInputs.append('<div class="mb-3">\n' +
            '                   <label for="company" class="form-label">Company</label>\n' +
            '                   <input name="company" type="text" style="border: 1px solid #589EA6" class="form-control" id="company" required>\n' +
            '               </div>'+
            '               <p>\n' +
            '                   <a class="btn btn-primary" data-bs-toggle="collapse" href="#hourlyCollapse" role="button" aria-expanded="false" aria-controls="hourlyCollapse">Hourly</a>\n' +
            '                       <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#salaryCollapse" aria-expanded="false" aria-controls="salaryCollapse">Salary</button>\n' +
            '               </p>\n' +
            '               <div class="row">\n' +
            '                   <div class="col">\n' +
            '                      <div class="collapse multi-collapse" id="hourlyCollapse">\n' +
            '                          <div class="form-floating">\n' +
            '                              <input name="hourlyPay" type="number" step="0.01" class="form-control" id="hourlyPay" aria-describedby="hourlyHelp">\n' +
            '                              <label for="hourlyPay" >Hourly</label>\n' +
            '                          </div>\n' +
            '                      </div>\n' +
            '                   </div>\n' +
            '                   <div class="col">\n' +
            '                      <div class="collapse multi-collapse" id="salaryCollapse">\n' +
            '                          <div class="form-floating">\n' +
            '                               <input name="salary" type="number" class="form-control" id="Salary" aria-describedby="salaryHelp">\n' +
            '                               <label for="salary" >Salary</label>\n' +
            '                          </div>\n' +
            '                      </div>\n' +
            '                   </div>\n' +
            '               </div>')
    } else if (selectedVal === 'Pet'){
        $('#newEventForm').attr("action", "/event/pets")
        extraInputs.empty()
        extraInputs.append('<div class="mb-3">\n' +
            '                        <label for="petType" class="form-label">Pet Type</label>\n' +
            '                        <input name="petType" type="text" placeholder="Dog" style="border: 1px solid #589EA6" class="form-control" id="petType" required>\n' +
            '                    </div>')
    } else {
        $('#newEventForm').attr("action", "/event/other")
        extraInputs.empty()
    }
    $("#newEventForm").attr("method", "post")
}

$('#selectEventType').change(() =>adjustModalForm("Add"))




$(".deleteButton").on("click", (event) => {
    console.log(event.target.dataset.eventdata)
    console.log(event.target.dataset.parentid)
    let typeAndId = event.target.dataset.eventdata
    let splitString = typeAndId.split(' ')

    let id = parseInt(splitString[1])

    fetch(`/event?eventType=${splitString[0]}&id=${id}`, {method: 'DELETE'})
        .then(res => console.log(res))
        .then(data => {
            console.log(data)
            location.reload()
        })

    let parentId = event.target.dataset.parentid
    $(`#${parentId}`).remove()
})

$(".editButton").click((event) => {
    let arrayData = event.target.dataset.eventdata.split('!')
    // open model and populate with data
    let type = arrayData[0]
    let eventId = arrayData[1]
    let title = arrayData[2]
    let startDate = arrayData[3]
    let endDate = arrayData[4]
    let notes = arrayData[5]
    let petType, company, salary, hourlyPay

    $("#selectEventType").val(type)
    adjustModalForm("Edit")
    $("#newEventForm").attr("method", "put")
    $("#newEventForm").attr("action", `/event/Other?id=${eventId}`)
console.log(`type == ${type}`)
    if(type === "Pet"){
        petType = arrayData[6]
        $("#newEventForm").attr("action", `/event/Pets?id=${eventId}`)
        $("#petType").val(petType)
    }
    if(type === "Job"){
        company = arrayData[6]
        salary = arrayData[7]
        hourlyPay = arrayData[8]
        $("#company").val(company)
        $("#hourlyPay").val(hourlyPay)
        $("#Salary").val(salary)
        $("#newEventForm").attr("action", `/event/Jobs?id=${eventId}`)
    }
    $("#eventId").val(eventId)
    $("#title").val(title)
    $("#startDate").val(startDate)
    $("#endDate").val(endDate)
    $("#notes").val(notes)

})
