const alkalmazott = require("../Models/AlkalmazottModel")

exports.createAlkalmazott = async (req, res) => {
    try{

        const ujAlk = await alkalmazott.create(req.body)

        res.status(200).json({
            status: "sikeresen létrehozva."
        })


    }catch(e){
        res.status(400).json({
            status: "hiba"
        })
    }
}

exports.getAllAlkalmazott = async (req, res) => {
    try{

        const alaklmazottak = await alkalmazott.find()

        res.status(200).json({
            value: alaklmazottak
        })

    }catch(e){
        res.status(400).json({
            status: "hiba"
        })
    }
}

exports.getAlkalmazottById = async (req, res) => {
    try{

        const alkalmazottByid = await alkalmazott.findById(req.params.id);
        
        res.status(200).json({
            value: alkalmazottByid
        })

    }catch(e){
        res.status(400).json({
            error: "hiba"
        })
    }
}

exports.updateAlkalmazott = async (req, res) => {
    try{

        const modalk = await alkalmazott.findByIdAndUpdate(req.params.id, req.body)

        res.status(200).json({
            success: "Sikeres módosítás."
        })


    }catch(e){
        res.status(400).json({
            error: "hiba"
        })
    }
}

exports.deleteAlkalmazott = async (req, res) => {
    try{

        const del = await alkalmazott.findByIdAndDelete(req.params.id, req.body);

        res.status(200).json({
            sucess : "sikeres törlés"
        })

    }catch(e){
        res.status(400).json({
            error: "hiba"
        })
    }
}