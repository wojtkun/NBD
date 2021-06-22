var mapFunction = function () {
    if (this.sex === "Female", this.nationality === "Poland")
        for (var i = 0; i < this.credit.length; i++) {
            emit( this.credit[i].currency, {value: parseFloat(this.credit[i].balance)});
        };
}
var reduceFunction = function (id, stan_kont) {
	let suma = 0
    let count = 0

    stan_kont.forEach(function (stan_konta) {
        //count += stan_konta.count;
		count++;
        suma += stan_konta.value;
    });

    return {
        suma: suma,
        count: count,
    }
};
var finalizeFunction = function (id, stan_kont) {
    return {
        suma: stan_kont.suma,
        average: stan_kont.suma / stan_kont.count
    }
};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        finalize: finalizeFunction,
        out: { inline: 1 },
    }
));