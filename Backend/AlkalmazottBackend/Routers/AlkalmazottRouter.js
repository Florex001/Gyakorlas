const express = require("express");
const alkalmazottController = require("../Controllers/AlkalmazottController")

const router = express.Router();

router
    .route("/")
    .get(alkalmazottController.getAllAlkalmazott)
    .post(alkalmazottController.createAlkalmazott);

router
    .route("/:id")
    .patch(alkalmazottController.updateAlkalmazott)
    .delete(alkalmazottController.deleteAlkalmazott)
    .get(alkalmazottController.getAlkalmazottById);

module.exports = router;