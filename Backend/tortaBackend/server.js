const mongoose = require('mongoose')

const app = require('./app')

const DB = "mongodb://localhost:27017/Torta"

mongoose.connect(DB, {
    useNewUrlParser: true
})
.then(() => console.log('Adatbázis csatlakozott'))

const port = 3001

app.listen(port, ()=> {
    console.log('az alkalmazás a 3001 es porton fut.');
})