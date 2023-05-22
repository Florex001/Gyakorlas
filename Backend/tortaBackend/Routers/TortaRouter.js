const express = require('express')
const tortaController = require('../Controllers/TortaController')

const router = express.Router()

router
    .route('/')
    .get(tortaController.getAllTorta)
    .post(tortaController.createTorta);

router
    .route('/:id')
    .delete(tortaController.deleteTorta)
    .patch(tortaController.updateTorta)
    .get(tortaController.getTortaById);

module.exports = router;