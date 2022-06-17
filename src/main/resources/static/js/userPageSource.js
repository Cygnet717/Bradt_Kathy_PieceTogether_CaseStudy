
console.log("connected to userpage source.js")

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
            '                              <input name="hourly" type="text" class="form-control" id="hourly" aria-describedby="hourlyHelp">\n' +
            '                              <label for="hourly" >Hourly</label>\n' +
            '                          </div>\n' +
            '                      </div>\n' +
            '                   </div>\n' +
            '                   <div class="col">\n' +
            '                      <div class="collapse multi-collapse" id="salaryCollapse">\n' +
            '                          <div class="form-floating">\n' +
            '                               <input name="salary" type="text" class="form-control" id="Salary" aria-describedby="salaryHelp">\n' +
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


const sendDeleteRequest = (id) => {

    fetch(`/event?id=${id}`, {method: 'delete'})
        .then(res => console.log(res))
        .then(c => location.reload())
}