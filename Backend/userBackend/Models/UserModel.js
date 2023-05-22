const mongoose = require("mongoose")

const user = new mongoose.Schema({
    username: {
        type: String
    },
    password: {
        type: String
    }
})

const User = mongoose.model('felhasznalo', user)

module.exports = User;