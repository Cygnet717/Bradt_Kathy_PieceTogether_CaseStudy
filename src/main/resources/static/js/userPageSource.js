
console.log("connected to user page source.js")

const extraInputs = $("#extraInputs")

$('#selectEventType').change(() => {
    let selectedVal = $('#selectEventType').val()
    $('#modalHeader').text(`Add ${selectedVal} Event`)

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

})



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
    console.log(arrayData)
    // open model and populate with data


})
