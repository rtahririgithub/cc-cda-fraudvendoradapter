# cc-cda-fraudvendoradapter	

This is a sample Google Cloud Pub/Sub Application to demonstrate the following feature implemetation:  
- [Logging](docs/logging-java.md) 
- [Environment Configuration](docs/env-config.md)
- [Unit Testing](docs/unit-tests-java.md)
- [BDD Testing](docs/bdd-tests-java.md)
- [Pub/Sub](docs/pub-sub.md)
- [SonarQube Integration](docs/sonarqube-integration-java.md) with optional [Slack Integration](.github/workflows/sonarqube-slack-integration.yml)
- [Risk Engine Integration](docs/risk-engine.md)
- [Swagger File Creation](docs/swagger-creation.md)
- [GKE Cron Job](docs/gke-cron-job.md)   
- [Cloud Scheduler for PubSub](docs/cloud-scheduler.md)  
- [Backstage Software Catalog](docs/backstage-catalog.md)
- [Log-Based Metrics and Slack Notifications](docs/log-metrics.md)
- [Health Check](docs/healthcheck.md)

This project also includes [API Documentation Template](API-Documentation_v1.0.md) that teams will be required to complete when creating APIs.

## Prerequisite
Before you begin, make sure that you have access to a GCP Project where you would be able to connect to and test your applications. If you need to request for a new GCP project, follow the instruction [here]( https://onboard.cloudapps.telus.com/onboard/home )

In order to run the Google Cloud Pub/Sub sample application, you will need to ensure that the Topic and Subscription you specify in the cookiecutter.yaml file is created in your GCP Project. To create a topic and subscription, follow the instructions [here](docs/pub-sub.md)

## Select your development environment:  

### [Github Codespaces Development](#using-github-codespaces-development)  
### [Local Development](#using-local-development)  
___
## **Using Github Codespaces Development** 

1- Make sure that Github Codespaces feature is activated for your Githib account.  
2- Click on the green 'Code' button, select Codespaces tab and 'New Codespace' button.  
3- Wait for the codespace VM to be initialized. At this point a development VM is being provisioned and initialized which will include the sample application, google cloud SDK, and any required files associated with the features selected in the cookiecutter file when you created the repository from the template.  

**This sample app requires an active GCP project, follow the steps below to activate your GCP Cloud SDK:**

#### **GCP Cloud SDK Integration + Activation**
From a new terminal within codespaces, run the following command to initialize Google Cloud SDK:

    gcloud init --no-launch-browser

Follow the prompts to authenticate and connect to your GCP Project.

#### **GCP Application Authentication**
If you want your local application to temporarily use your own user credentials for API access, run:  

    gcloud auth application-default login --no-launch-browser

See [Local Application Authentication](https://cloud.google.com/sdk/gcloud/reference/auth/application-default/login) for more detail instruction.

### Developing in Github Codepspaces without a Google Cloud Project  

Since the sample application is using [stackdriver logging](https://docs.spring.io/spring-cloud-gcp/docs/current/reference/html/logging.html#_stackdriver_logging) library for Java Spring Boot, it requires the GOOGLE_CLOUD_PROJECT environment variable to be set before excuting the application. In order to set the variable locally, **when not having access to a GCP project**, execute the following commands:

```bash
# on a -nix based os
> export GOOGLE_CLOUD_PROJECT=local

# in a windows command prompt where you will run mvn:
> set GOOGLE_CLOUD_PROJECT=local
```
___

## **Using Local Development**
First, download the Google Cloud CLI from [here](https://cloud.google.com/sdk/docs/install) onto your local machine.

On Windows, the download will include a Google Cloud CLI Shell in which you will input commands for the following steps.

On Linux systems, you may simply input the commands in your terminal.

Follow the instruction [here](https://simplify.telus.com/docs/default/component/developer-docs/guides/setting-up-your-local-development-environment-2Lo7y4qy7DezIYk1ltfykF/#configuring-the-http-proxy-while-on-the-vpn) to setup your local development environment network.

#### **Cloning This Repo**
To clone this repo onto your local machine:

1- Click on the green 'Code' button, select the Local tab, and copy the URL in the box.   
2- In your terminal, enter the following command where `<copied url>` is replaced with the URL you copied

    git clone <copied url>

You may have to enter your Github credentials to execute this command. Confirm that the repo exists in your current
directory by entering the `dir` (for Windows) or `ls` (for Linux) command into your terminal.

**This sample app requires an active GCP project, follow the steps below to activate your GCP Cloud SDK:**

#### **GCP Cloud SDK Integration + Activation**
From the Google Cloud CLI Shell/terminal, run the following command to initialize Google Cloud SDK:

    gcloud init --no-launch-browser

Follow the prompts to authenticate and connect to your GCP Project.

#### **GCP Application Authentication**
If you want your local application to temporarily use your own user credentials for API access, run:  

    gcloud auth application-default login --no-launch-browser

See [Local Application Authentication](https://cloud.google.com/sdk/gcloud/reference/auth/application-default/login) for more detail instruction.

### Developing in local environment without a Google Cloud Project  
Since the sample application is using [stackdriver logging](https://docs.spring.io/spring-cloud-gcp/docs/current/reference/html/logging.html#_stackdriver_logging) library for Java Spring Boot, it requires the GOOGLE_CLOUD_PROJECT environment variable to be set before executing the application. In order to set the variable locally, **when not having access to a GCP project**, execute the following command:

```bash
# on a -nix based os
> export GOOGLE_CLOUD_PROJECT=local

# in a windows command prompt where you will run mvn:
> set GOOGLE_CLOUD_PROJECT=local
```
___

## **Try the sample application**

In your terminal, `cd` into the root directory of your local repository. Enter the following command to test your sample application directly in the terminal:

    mvn spring-boot:run

This will run the application with the JVM arguments specified in your [pom.xml](pom.xml) (check the configuration comment under `spring-boot-maven-plugin`.)

To package the sample app into a runnable JAR file, enter the following command:

    mvn package

This should produce a JAR file in a directory named `target/` (for example `target/spring-boot-0.0.1-SNAPSHOT.jar`). To run the app, enter the following command:

    java -jar <path to your JAR file>

In our example, `<path to your JAR file>` would be replaced with `target/spring-boot-0.0.1-SNAPSHOT.jar`.
Applications run using `java -jar ...` do not use the JVM arguments listed in `pom.xml`, so they must be entered explicitly in the command (as in the
[Dockerfile](Dockerfile).) For example:

    java -Xmx2048m -Xdebug -DargumentName=someValue -jar <path to your JAR file>

Once the app has started: go to your web browser, type `localhost:8080` into the address bar, and play around with the webpages.

To stop the app, use `Ctrl + C` in the terminal.

To package the app again after having made changes, run:

    mvn clean
    mvn package

___

## Adding Collaborators and Working Together
The owner of this repository can add additional admins or collaborators (documentation on access to repositories can be found [here](https://docs.github.com/en/organizations/managing-access-to-your-organizations-repositories/repository-roles-for-an-organization).)

You may currently not have the ability to push code to your `main` branch without additional reviewers. To further customize the rules governing how code is pushed to your branches, [edit your branch protection rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/managing-a-branch-protection-rule).

<img src="https://user-images.githubusercontent.com/50889765/191091612-071ccdd1-a4c9-4910-b10a-055c44180ef5.png" width=40% height=40% />

We highly recommend that you add an additional reviewer/approver; however, technically as an admin and repo creator, you can bypass by checking the checkbox "*Merge without waiting for requirements to be met*"

___

## Including CI/CD for your API
👉 **Prerequisite** Add IAM binding for the cicd-service-account@<PROJECT_ID>.iam.gserviceaccount.com to your application repositories via terraform, see [example](https://github.com/telus/tf-infra-cdo-horizon/blob/master/terraform/iam.tf#:~:text=Blame-,module%20%22cicd%2Dwif%2Diam%22%20%7B,%7D,-module%20%22cloudsql%2Dsa)

For more information on how to set up CI/CD using Cloud Deploy and GitHub Workflows, please see [this](https://github.com/telus/ep-cicd-generator) repository from Engineering Productivity.

A pull request should be received on this repository soon after it has been generated with sample CI/CD configurations for deploying an API to GKE.
  

View a tutorial video on how to [Add your Github repository to CICD Workload Identity Access List](https://drive.google.com/file/d/1ZlfZi7XW0Pew_AS9Fs-Hs1TCoSjv3yNA/view)

<img src="https://user-images.githubusercontent.com/50889765/175146339-67cd2882-de2c-4bda-968e-5d2b75115fed.png" width=25% height=25% />

👉 **Merge** the Pull Request. If Merging is blocked, see instructions above on [Branch Protection Rules](README.md#adding-collaborators-and-working-together) **or** click *Add your review* then approve

<img src="https://user-images.githubusercontent.com/50889765/175160302-8b4ef6f0-92b4-4449-80ba-c818d5689d47.png" width=40% height=40% />

<img src="https://user-images.githubusercontent.com/50889765/175146339-67cd2882-de2c-4bda-968e-5d2b75115fed.png" width=25% height=25% />

👉 **Merge** the Pull Request. If Merging is blocked, see instructions above on [Branch Protection Rules](README.md#adding-collaborators-and-working-together) **or** click *Add your review* then approve

<img src="https://user-images.githubusercontent.com/50889765/175160302-8b4ef6f0-92b4-4449-80ba-c818d5689d47.png" width=40% height=40% />

___

## Port Forwarding a Deployed Application Tutorial Video

View this tutorial video on how to [Port-forward a GKE workload to your local host](https://drive.google.com/file/d/1tNU-iZ80pcBnBSPSYQfFe_z0p0VDPB73/view?usp=sharing)

GCloud CLI Installation: https://cloud.google.com/sdk/docs/install

Command line cheat-sheet: [cheatSheet.txt](docs/cheatSheet.txt)

___

## Deploying the Application to Production
Given that your application has been tested in non-production, follow [this guide](docs/production.md) to promote your application to your production GCP project.

___

## Your feedback is important to us
📝 We are continuously adding more sample applications to the Software Template, implementing new features and functionalities. To help us improve the quality and content of our Software Template, we appreciate your feedback by completing [this short survey](https://forms.gle/UbotjxDVsDmTB3D16), or posting your comments to our [Slack Channel](https://telus-cdo.slack.com/archives/C02KRKNFA2J).
