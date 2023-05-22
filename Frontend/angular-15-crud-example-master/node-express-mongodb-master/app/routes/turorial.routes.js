module.exports = app => { // Express alkalmazást vár paraméterként

  const tutorials = require("../controllers/tutorial.controller.js"); // Tutorial kontroller importálása

  var router = require("express").Router(); // Express útvonalkezelő objektum létrehozása

  // Új Tutorial létrehozása
  router.post("/", tutorials.create);

  // Az összes Tutorial lekérése
  router.get("/", tutorials.findAll);

  // Az összes publikált Tutorial lekérése
  router.get("/published", tutorials.findAllPublished);

  // Egyetlen Tutorial lekérése az azonosítóval
  router.get("/:id", tutorials.findOne);

  // Tutorial frissítése az azonosítóval
  router.put("/:id", tutorials.update);

  // Tutorial törlése az azonosítóval
  router.delete("/:id", tutorials.delete);

  // Az összes Tutorial törlése
  router.delete("/", tutorials.deleteAll);

  app.use("/api/tutorials", router); // Útvonal hozzáadása az alkalmazáshoz
};
