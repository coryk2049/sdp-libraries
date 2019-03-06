/*
  Copyright © 2018 Booz Allen Hamilton. All Rights Reserved.
  This software package is licensed under the Booz Allen Public License. The license can be found in the License file or at http://boozallen.github.io/licenses/bapl
*/

def call(p_name) {
  stage "Stopping Container", {
    node{
      unstash "workspace"
        sh "docker ps -f name=${p_name} -q | xargs --no-run-if-empty docker container stop"
        // sh "docker container ls -a -fname=${p_name} -q | xargs -r docker container rm"
      }
    }
  }
}
