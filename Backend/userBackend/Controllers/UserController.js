const User = require("../Models/UserModel");

exports.createUser = async (req, res) =>{
    try{
        const newUser = await User.create(req.body)

        res.status(200).json({
            data: {
                User: newUser
            }
        })

    }catch(e){
        res.status(400).json({
            status: "hiba"
        })
    }
}

exports.getAllUser = async (req, res) => {
    try{

        const alluser = await User.find();

        res.status(200).json({
            User: alluser
        })

    }catch (e){
        res.status(400).json({
            status: "hiba"
        })
    }
}

exports.getUserById = async (req, res) => {
    try{

        const user = await User.findById(req.params.id)

        res.status(200).json({
            User: user
        })

    }catch(e){
        res.status(400).json({
            status: "hiba"
        })
    }
}

exports.updateUser = async (req, res) => {
    try{

        const modositott = await User.findByIdAndUpdate(req.params.id, req.body);

        res.status(200).json({
            User: "sikeres modositas"
        })

    }catch(e){
        res.status(400).json({
            status: e
        })
    }
}

exports.deleteUserById = async (req, res) => {
    try{

        const deleteUser = await User.findByIdAndDelete(req.params.id)

        res.status(200).json({
            status: "Sikeres Törlés"
        })

    }catch(e){
        res.status(400).json({
            status: "hiba"
        })
    }
}