printjson(db.people.aggregate([{ $addFields: { bmi: {$multiply: [10000,{$divide: [{ $toDouble: "$weight" }, { $multiply: [{ $toDouble: "$height" }, { $toDouble: "$height" }] }]}]}}},
        {$group: { _id: "$nationality", bmi_minimum: { $min: "$bmi" }, bmi_srednia: { $avg: "$bmi" }, bmi_maximum: { $max: "$bmi" },}}]));