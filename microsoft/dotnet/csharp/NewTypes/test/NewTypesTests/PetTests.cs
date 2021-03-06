using System;
using Xunit;
using Pets;

namespace PetTests
{
    public class PetTests
    {
        [Fact]
        public void DogTalkToOwnerReturnsWoof()
        {
            string expected = "Woof!";

            string actual = new Dog().TalkToOwner();

            Assert.Equal(expected, actual);
        }

        [Fact]
        public void CatTalkToOwnerReturnsWoof()
        {
            string expected = "Meow!";

            string actual = new Cat().TalkToOwner();

            Assert.Equal(expected, actual);
        }
    }
}
