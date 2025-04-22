% Predicate: my_member(Element, List)
% Checks whether Element is a member of List.
my_member(X, [X|_]).
my_member(X, [_|T]) :-
    my_member(X, T).


% Predicate: my_append(List1, List2, Result)
% Appends List1 and List2 into Result.
my_append([], L, L).
my_append([H|T], L2, [H|R]) :-
    my_append(T, L2, R).


% Predicate: my_reverse(InputList, ReversedList)
% Reverses InputList into ReversedList.
my_reverse([], []).
my_reverse([H|T], R) :-
    my_reverse(T, RevT),
    my_append(RevT, [H], R).

