Runs:
 - Chrome and Firefox 11 on Windows Server 2003, Windows Server 2008, and Linux.

Depends on [livepreview_test](https://github.com/bootstraponline/livepreview_test)

JavaScript generated from [livepreview_test_gen](https://github.com/bootstraponline/livepreview_test_gen)

# Test results

- [Jun 8](https://github.com/bootstraponline/livepreview_test_sauce/wiki/Test-Results-Jun-8)
- [Jun 18](https://github.com/bootstraponline/livepreview_test_sauce/wiki/Test-Results-Jun-18)
- [Aug 9](https://github.com/bootstraponline/livepreview_test_sauce/wiki/Test-Results-Aug-9)

---

```
git clone git://github.com/bootstraponline/livepreview_test_sauce.git
git clone git://github.com/bootstraponline/livepreview_test.git
```

Import both as existing maven project into Eclipse and add livepreview_test to the build path of livepreview_test_sauce.

---

http://username:key@ondemand.saucelabs.com:80/wd/hub

`sauce.key` - sauce key

`user.key` - sauce username
