const torta = require("../Models/TortaModel")

exports.createTorta = async (req, res) => {
    try {

        const newTorta = await torta.create(req.body)

        res.status(200).json({
            success: "létre hoztad az új tortád"
        })
        
    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })
    }
}

exports.getAllTorta = async (req, res) => {
    try {
        
        const osszes = await torta.find()

        res.status(200).json({
            torta: osszes
        })

    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })
    }
}

exports.getTortaById = async (req, res) => {
    try {
        
        const egytorta = await torta.findById(req.params.id)

        res.status(200).json({
            Torta: egytorta
        })

    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })
        
    }
}

exports.updateTorta = async (req, res) => {
    try {

        const modositott = await torta.findByIdAndUpdate(req.params.id, req.body)

        res.status(200).json({
            success: "Sikeres módosítás"
        })
        
    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })
    }
}

exports.deleteTorta = async (req, res) =>{
    try {

        const torol = await torta.findByIdAndDelete(req.params.id)
        
        res.status(200).json({
            success: "Sikeres törlés"
        })

    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })
    }
}