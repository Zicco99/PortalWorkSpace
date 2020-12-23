#!/bin/bash
function portal() {
  cd /home/chilledpanda/PortalWorkSpace/
  make desk="$1" execute
  cd /home/chilledpanda/Scrivania/
}
