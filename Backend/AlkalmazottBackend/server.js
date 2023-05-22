const mongoose = require("mongoose")

const app = require("./app")

const DB = "mongodb://localhost:27017/Workers"

mongoose.connect(DB, {
    useNewUrlParser: true
}).then(() => console.log("Adatbázis aktív."))

const port = 3001;

app.listen(port, () => {
    console.log("Az alkalmazás a 3001 es porton fut.");
})