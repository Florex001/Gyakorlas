const mongoose = require('mongoose')

const torta = new mongoose.Schema({
    izesites: {
        type: String
    },
    cukormentese: {
        type: Boolean
    },
    retegek: {
        type: Number
    }
})

const Torta = mongoose.model('Torta', torta)

module.exports = Torta