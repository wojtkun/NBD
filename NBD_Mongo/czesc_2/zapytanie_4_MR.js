var mapFunction = function () {
    emit(
        this.nationality,
        { waga: this.weight, wzrost: this.height }
    );
};

var reduceFunction = function (id, osoby) {
    var max = 0
	var min = 99999
    var count = 0
    var suma = 0

    osoby.forEach(function (osoba) {
		bmi=(osoba.waga *10000) / (osoba.wzrost * osoba.wzrost);
        count++;
        suma += bmi
        if (bmi > max)
            max = bmi
        if (bmi < min)
            min = bmi
    });
    return {suma: suma, count: count, max: max, min: min }

};
var finalizeFunction = function (id, bmi) {
    let srednia = bmi.suma / bmi.count

    return { srednia: srednia, max: bmi.max, min: bmi.min }

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        finalize: finalizeFunction,
        out: { inline: 1 },
    }
));