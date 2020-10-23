BasicPartition(A, p, r)

    return q
    in which case
    A[p..q] <= A[q] <= A[q+1..r]


EnhancedPartition(A, p, r)

    return i+1, k+1
    in which case
    A[p..i] < A[i+1..k] < A[k+1..r]
    
    
BasicQuicksort(A, p, r)

    sort A in place
    calling BasicPartition
    
    
EnhancedQuicksort(A, p, r)

    sort A in place
    calling EnhancedPartition