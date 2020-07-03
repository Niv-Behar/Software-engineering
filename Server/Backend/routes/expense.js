//IMPORTS:
const express = require('express');
const router = express.Router();
const Expense = require('../models/expense');
const checkAuth = require('../middlewares/check-auth');


router.post('', checkAuth, (req, res) => {
    const expense = new Expense({
        title: req.body.title,
        amount: req.body.amount,
        creator: req.userData.userId,
        categoryId: req.body.categoryId
    });
    expense.save().then(createdExpense => {
        res.status(201).json({
            _id: createdExpense._id
        });
    }).catch(() => {
        res.status(500).json({ message: "Unknown Error!" });
    })
})

router.get('', checkAuth, (req, res) => {
    Expense.find({ creator: req.userData.userId }).then(documents => {
        res.status(200).json({
            expenses: documents
        });
    }).catch(err => {
        res.status(500).json({});
    })
})

router.delete('/:_id', checkAuth, (req, res) => {
    Expense.deleteOne({ _id: req.params._id, creator: req.userData.userId }).then(result => {
        if (result.n > 0) {
            res.status(200).json({ message: "Success" });
        }
        else {
            res.status(401).json({ message: "Auth failed!" });
        }
    }).catch(err => {
        res.status(500).json({ message: "Auth failed!" });
    })
})

//Delete all expenses in a category!
router.delete('/:categoryId/all', checkAuth, (req, res) => {
    Expense.deleteMany({ creator: req.userData.userId, categoryId: req.params.categoryId })
        .then(result => {
            //Will be used when deleting a whole category !
            res.status(200).json({ message: "Success" });
        }).then(err => {
            res.status(500).json();
        })
})

router.delete('', checkAuth, (req, res) => {
    Expense.deleteMany({ creator: req.userData.userId }).then(result => {
        res.status(200).json({});
    }).catch(err=>{
        res.status(500).json();
    })
})

router.put("", checkAuth, (req, res) => {
    const expense = new Expense({
        title: req.body.title,
        amount: req.body.amount,
        creator: req.userData.userId,
        categoryId: req.body.categoryId,
        _id: req.body._id
    });
    Expense.updateOne({ _id: req.body._id }, expense).then(result => {
        if (result.n > 0) {
            res.status(200).json({ message: success });
        }
        else {
            res.status(401).json({ message: "Auth failed!" });
        }
    }).catch(err => {
        res.status(500).json({ mesasge: "Unknown Error!" });
    })
})

module.exports = router;
