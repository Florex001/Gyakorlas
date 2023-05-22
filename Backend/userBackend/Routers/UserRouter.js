const express = require("express")
const userController = require("../Controllers/UserController")

const router = express.Router();

router
    .route("/")
    .get(userController.getAllUser)
    .post(userController.createUser);

router
    .route("/:id")
    .delete(userController.deleteUserById)
    .patch(userController.updateUser)
    .get(userController.getUserById);

module.exports = router;