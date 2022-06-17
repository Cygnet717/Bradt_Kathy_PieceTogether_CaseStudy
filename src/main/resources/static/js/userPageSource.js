
console.log("connected poopy to  userpage source.js")

const eventTypeSelector = document.getElementById("selectEventType")
const modalHeaderEl = document.getElementById("modalHeader")

const updateModalHeader = () => {
    modalHeaderEl.innerText = `Add ${eventTypeSelector.value} Event`
}

const sendDeleteRequest = (id) => {

    fetch(`/event?id=${id}`, {method: 'delete'})
        .then(res => console.log(res))
        .then(c => location.reload())
}