const mongoose = require("mongoose")

const alkalmazott = new mongoose.Schema({
    nev: {
        type: String
    },
    fizetes: {
        type: Number
    },
    beoszatas: {
        type: String
    }
})

const Alkalmazott = mongoose.model("worker", alkalmazott)

module.exports = Alkalmazott;