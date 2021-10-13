using System;
using Xunit;
using Numbers;

namespace XUnit.Coverlet
{
    public class PrimeServiceTests
    {
        readonly PrimeService _primeService;

        public PrimeServiceTests() => _primeService = new PrimeService();

        [
            Theory,
            InlineData(-1), InlineData(0), InlineData(1)
        ]
        public void IsPrime_ValuesLessThan2_ReturnFalse(int value) =>
                Assert.False(_primeService.IsPrime(value),
                        $"{value} should be no prime.");

        [
            Theory,
            InlineData(2), InlineData(3), InlineData(5), InlineData(7)
        ]
        public void IsPrime_PrimesLessThan10_ReturnTrue(int value) =>
                Assert.True(_primeService.IsPrime(value),
                        $"{value} should be prime.");

        [
            Theory,
            InlineData(4), InlineData(4), InlineData(8), InlineData(9)
        ]
        public void NonPrime_PrimesLessThan10_ReturnFalse(int value) =>
                Assert.False(_primeService.IsPrime(value),
                        $"{value} should be prime.");
    }
}
