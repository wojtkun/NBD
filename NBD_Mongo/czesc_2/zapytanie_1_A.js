printjson(db.people.aggregate([
{$group:{"_id":"$sex", Srednia_waga:{$avg:{$toDouble: "$weight"}},Sredni_wzrost:{$avg:{$toDouble: "$height"}}}}
]))