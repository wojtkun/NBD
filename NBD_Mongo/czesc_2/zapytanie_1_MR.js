var mapFunction = function () {
	emit(this.sex,
	{
		waga: parseFloat(this.weight), wzrost: parseFloat(this.height)});
};

var reduceFunction = function (id, osoby)
{
	let suma_wzrost = 0
	let suma_waga = 0
	let count = 0
	osoby.forEach(function(osoba){
		suma_wzrost+=osoba.wzrost
		suma_waga+=osoba.waga
		count++
	});
	return {wzrost : suma_wzrost,waga:suma_waga, count: count};
};

var finalizeFunction = function (id, osoba){
	//let out = osoba.srednia / osoba.count
	return {srednia_waga : osoba.waga / osoba.count, sredni_wzrost: osoba.wzrost / osoba.count }
};

printjson(
    db.people.mapReduce(
        mapFunction,
        reduceFunction,
        {
            finalize: finalizeFunction,
            out: { inline: 1 },
        })
);