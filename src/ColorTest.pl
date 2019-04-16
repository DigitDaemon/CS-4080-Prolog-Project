%Patterns

%patternOne(TL, TR, BL, BR) :-
%    isYellow(TL),
%    isMagenta(TR),
%    isCyan(BL),
%    isWhite(BR).

%patternTwo(TL, TR, BL, BR) :-
%    isBlue(TL),
%    isRed(TR),
%    isGreen(BL),
%    isYellow(BR).

patternThree(TL, TR, BL, BR) :-
    isBlue(TL),
    isRed(TR),
    isGreen(BL),
    isPurple(BR).

%Color Functions
printRGB(N) :-
    Color is N mod 16777216,
    R is Color >> 16, writeln(R),
    G is Color >> 8 mod 256, writeln(G),
    B is Color mod 256, writeln(B).

isRed(N) :-
    Color is N mod 16777216,
    R is Color >> 16, between(1, 255, R),
    G is Color >> 8 mod 256,
    B is Color mod 256,
    G/R < 1,
    B/R < 1.

isBlue(N) :-
    Color is N mod 16777216,
    R is Color >> 16,
    G is Color >> 8 mod 256,
    B is Color mod 256, between(1, 255, B),
    R/B < 1,
    G/B < 1.

isGreen(N) :-
    Color is N mod 16777216,
    R is Color >> 16,
    G is Color >> 8 mod 256, between(1, 255, G),
    B is Color mod 256,
    R/G < 1,
    B/G < 1.

isPurple(N) :-
    Color is N mod 16777216,
    R is Color >> 16, between(1, 255, R),
    G is Color >> 8 mod 256,
    B is Color mod 256, between(1, 255, B),
    G/R < 1,
    G/B < 1.

%high(N) :- N >= 200.
%low(N) :- N =< 55.

%isWhite(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, high(R),
%    G is N >> 8 mod 256, high(G),
%    B is N mod 256, high(B).

%isNotWhite(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, \+ high(R),
%    G is N >> 8 mod 256, \+ high(G),
%    B is N mod 256, \+ high(B).

%isYellow(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, high(R),
%    G is N >> 8 mod 256, high(G),
%    B is N mod 256, low(B).

%isMagenta(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, high(R),
%    G is N >> 8 mod 256, low(G),
%    B is N mod 256, high(B).

%isCyan(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, low(R),
%    G is N >> 8 mod 256, high(G),
%    B is N mod 256, high(B).

%isRed(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, high(R),
%    G is N >> 8 mod 256, low(G),
%    B is N mod 256, low(B).

%isGreen(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, low(R),
%    G is N >> 8 mod 256, high(G),
%    B is N mod 256, low(B).

%isBlue(N) :-
%    between(0, 16777215, N),
%    R is N >> 16 mod 256, low(R),
%    G is N >> 8 mod 256, low(G),
%    B is N mod 256, high(B).
