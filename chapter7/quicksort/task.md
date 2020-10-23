BasicPartition(A, p, r)

    return q
    in which case
    A[p..q] <= A[q] <= A[q+1..r]


EnhancedPartition(A, p, r)

    return i, k
    in which case
    A[p..i-1] < A[i..k] < A[k+1..r]
    
    
BasicQuicksort(A, p, r)

    sort A in place
    calling BasicPartition
    
    
EnhancedQuicksort(A, p, r)

    sort A in place
    calling EnhancedPartition
    
    
EnhancedFuzzyPartition(A, p, r)

    return i, k
    in which case
    A[p..i-1] < A[i..k] < A[k+1..r]
    
    
EnhancedFuzzyQuicksort(A, p, r)

    sort A in place
    calling EnhancedFuzzyPartition 