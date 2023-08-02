# Blockchain Project Journal

### A record of the creation process

---

**8/1/23**

The blockchain project has some solid ground.  I've established repositories for the three working components I've designed so far.
This includes the API, the Admin Web Client, and the Field Mobile Client.  Each repository has a strong CI/CD.  Each project has a README, 
CHANGELOG, and unit testing.

I've procured a remote server to test the API.  The Admin Client runs remotely through GitHub pages.  I'm still searching for a remote 
testing environment for the Mobile Client.

The API has a few endpoints stubbed out, including a health check.  Both clients have been wired up to the API and successfully poll for 
the health check.

### Status

All pieces are working as designed.  All code compiles and passes unit testing.  All CI/CD pipelines deploy successfully.

### Next Steps

I need to add an endpoint to the API that will add a block to the blockchain and another endpoint that returns the current blockchain.
Then I need to wire up the `addBlock` endpoint to a button on the Mobile Client.  Finally, I need to wire up the `getBlockchain` to the 
Admin Client.

As a side task, I also need to finish configuring the remote server for secure HTTP connections.  I currently have an NGINX web server 
but the certificate authority is not able to connect.  I'll be troubleshooting this, as well.
