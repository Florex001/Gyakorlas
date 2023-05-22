const express = require("express");
const alkalmazottRouter = require("./Routers/AlkalmazottRouter")

const app = express();

app.use(express.json())

app.use('/api/v1/worker', alkalmazottRouter)

module.exports = app;



