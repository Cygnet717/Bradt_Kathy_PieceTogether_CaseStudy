//register functionality
let registerUser = (e) => {
    e.preventDefault();

    //create new user in db and send on to a page for bulk add events
    //for now send on to logged in userPage
    window.location='/user'
    console.log("registred user")
}

//login functionality
let loginUser = (e) => {
    e.preventDefault()
    //validate user info using backend
    //if valid user then send to userPage
    window.location='/user'
    console.log("logined user")
}

