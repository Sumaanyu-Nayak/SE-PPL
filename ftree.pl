parent(john, mary).
parent(john, mike).
parent(susan, mary).
parent(susan, mike).
parent(mary, alice).
parent(mary, bob).
parent(david, alice).
parent(david, bob).

male(john).
male(mike).
male(david).
male(bob).

female(susan).
female(mary).
female(alice).


sibling(X, Y) :-
    parent(Z, X),
    parent(Z, Y),
    X \= Y.

grandparent(X, Y) :-
    parent(X, Z),
    parent(Z, Y).

aunt(X, Y) :-
    female(X),
    sibling(X, Z),
    parent(Z, Y).

uncle(X, Y) :-
    male(X),
    sibling(X, Z),
    parent(Z, Y).

cousin(X, Y) :-
    parent(A, X),
    parent(B, Y),
    sibling(A, B).