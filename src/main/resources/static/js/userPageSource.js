//Static data instead of a live DB
const eventData = {
    2020: [
        {
            type: "School",
            title: "Sword lessons from Boromir",
            date: '2020-10-26',
            notes: 'I picked it up faster than Merry and Pippin'
        },
        {
            type: "Family",
            title: "Boromir died",
            date: '2020-10-26',
            notes: 'I wasnt there but I was told it was epic'
        },
        {
            type: "Body Modification",
            title: "Stabbed by Shelob",
            date: '2020-10-26',
            notes: 'Why didnt my Mithril vest protect me?'
        }
    ],
    2018: [
        {
            type: "BodyModification",
            title: "Stabbed by Morgol Blade",
            date: '2018-10-26',
            notes: 'almost died LOL'
        },
        {
            type: "Pets",
            title: "adopted Gollum",
            date: '2018-10-26',
            notes: 'Caught him with an elven rope'
        },
        {
            type: "Vacation",
            title: "Visited Mordor",
            date: '2018-10-26',
            notes: 'Lost half my finger and my favorite ring'
        }
    ],
    2019: [
        {
            type: "Jobs",
            title: "Finished writing There and Back again",
            date: '2019-10-26',
            notes: ''
        },
        {
            type: "Family",
            title: "Bilbo sailed off to the undying lands",
            date: '2019-10-26',
            notes: 'And im going with him, no need to tell anyone beforehand '
        },
        {
            type: "Family",
            title: "Bilbo 111 years old",
            date: '2019-10-26',
            notes: 'Disappeared from his own party and left all his belongings to me'
        }
    ],
    2021:[
        {
            type: "Other",
            title: "Picked up by Eagles",
            date: '2021-10-26',
            notes: 'Why didnt they just fly us to mordor?'
        },
        {
            type: "Other",
            title: "Sam and I leave the Shire",
            date: '2021-10-26',
            notes: 'Merry and Pippin bumbled into comeing along'
        }
    ]

}

//Statid logged in user Frodo
let userFName = 'Frodo'
let userLName = 'Baggins'
const greetingBox = document.getElementById('greetingBox')
const accordion = document.getElementById('accordion')

//add event table to the accordion item
function addTableToAccordItem(year){

    for(let j=0; j<eventData[year].length; j++){
        let obj = eventData[year][j]
        // console.log(obj)
    //     let row = `<tr>
    //   <th scope='row'>${obj.type}</th>
    //   <td>${obj.title}</td>
    //   <td>${obj.date}</td>
    //   <td>${obj.date}</td>
    //   <td>${obj.notes}</td>
    // </tr>`
        let tr = document.createElement("tr")
        console.log("3333333333")
        let th = document.createElement("th")
            th.setAttribute("scope", "row")
            th.innerText = obj.type
        let td1 = document.createElement("td")
            td1.innerText = obj.title
        let td2 = document.createElement("td")
        td2.innerText = obj.date
        let td3 = document.createElement("td")
        td3.innerText = obj.date
        let td4 = document.createElement("td")
        td4.innerText = obj.notes
        let row = tr.appendChild(th).appendChild(td1).appendChild(td2).appendChild(td3).appendChild(td4)
   accordion.appendChild(row)
    }

}

//make accordion and top row of table and add it to the page
function loadUserDataToPage (eventData){

    greetingBox.append(userFName + " " + userLName)
    //make accordion item for each year
    let eventKeys = Object.keys(eventData)
    for(let i=eventKeys.length-1; i>=0; i--){

        let html = `
    <div id="accordionItem" class="accordion-item ${eventKeys[i]}">
        <h2 class="abutton collapsed" type="ccordion-header" id="heading${i}">
            <button id="formButton" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#collapse${i}" aria-expanded="false" aria-controls="collapse${i}">${eventKeys[i]}</button>
        </h2>
        <div id="collapse${i}" class="accordion-collapse collapse" aria-labelledby="heading${i}" data-bs-parent="#accordion">
            <div class="accordion-body">
                <table id='${eventKeys[i]}table' class='table table-dark table-hover'>
                    <tr>
                        <th scope="col">Event Type</th>
                        <th scope="col">Title</th>
                        <th scope="col">Start Date</th>
                        <th scope="col">End Date</th>
                        <th scope="col">Notes</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    `

        accordion.append(html)
        addTableToAccordItem(eventKeys[i]);
    }

}

//only if on the userPage run this function

loadUserDataToPage(eventData)

