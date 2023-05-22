module.exports = mongoose => { // Mongoose objektumot vár paraméterként

  var schema = mongoose.Schema( // Mongoose séma definiálása
    {
      title: String, // Cím mező típusa: szöveg
      description: String, // Leírás mező típusa: szöveg
      published: Boolean // Publikálva mező típusa: logikai érték
    },
    { timestamps: true } // Timestampek bekapcsolása a létrehozási és frissítési időpontokhoz
  );

  schema.method("toJSON", function() { // toJSON metódus hozzáadása a séma objektumához
    const { __v, _id, ...object } = this.toObject(); // Az objektumból kivesszük a verziószámot (__v) és az azonosítót (_id)
    object.id = _id; // Az azonosítót átnevezzük id-re
    return object; // Az objektumot visszaadjuk
  });

  const Tutorial = mongoose.model("tutorial", schema); // Tutorial adatbázis modell létrehozása a meghatározott sémával
  return Tutorial; // Tutorial modell visszaadása
};
