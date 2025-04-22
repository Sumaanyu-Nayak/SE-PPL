
(defun add (a b)
  (+ a b))

(defun subtract (a b)
  (- a b))

(defun multiply (a b)
  (* a b))

(defun divide (a b)
  (if (= b 0)
      "Error: Division by zero."
      (/ a b)))


(defun calculate (a op b)
  (typecase op
    (character
     (cond ((char= op #\+) (add a b))
           ((char= op #\-) (subtract a b))
           ((char= op #\*) (multiply a b))
           ((char= op #\/) (divide a b))
           (t "Error: Invalid operator.")))
    (symbol
     (cond ((eq op '+) (add a b))
           ((eq op '-) (subtract a b))
           ((eq op '*) (multiply a b))
           ((eq op '/) (divide a b))
           (t "Error: Invalid operator.")))
    (t "Error: Operator must be a symbol or character.")))
